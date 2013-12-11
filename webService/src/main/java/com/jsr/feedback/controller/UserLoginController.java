package com.jsr.feedback.controller;


import com.jsr.feedback.FeedBackConstants;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.bean.UsersRoles;
import com.jsr.feedback.model.LoginCommand;
import com.jsr.feedback.model.UserRegisterModel;
import com.jsr.feedback.service.UserInfoService;
import com.jsr.common.Constants;
import com.jsr.common.mail.SendMail;
import com.jsr.common.pagination.Page;
import com.jsr.common.shiro.realm.MD5;
import com.jsr.feedback.service.UserRolesService;
import com.octo.captcha.service.CaptchaServiceException;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-10
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserLoginController{
    private static Logger logger = Logger.getLogger(UserLoginController.class);
    @Autowired
    @Qualifier("imageCaptchaService")
    private com.octo.captcha.service.image.ImageCaptchaService imageCaptchaService;
    @Autowired
    @Qualifier("UserInfoService")
    private UserInfoService userService;
    @Autowired
    @Qualifier("passwordService")
    private PasswordService passwordService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }
    @RequestMapping(value = "/user_login", method = RequestMethod.POST)
    @ResponseBody
    public Map login( LoginCommand model, HttpServletRequest request) {
        Subject currentuser = SecurityUtils.getSubject();     //用户session
      //  isResponseCorrect  = validateCaptchaImage(request);
        boolean isResponseCorrect = true;
       if(!isResponseCorrect){      //验证失败
           return FeedBackConstants.getMessage(false, "验证码错误");
       }
        //检查是否被冻结
        Users u = userService.findUserByName(model.getUsername());
        if( u == null){
            return FeedBackConstants.getMessage(false,"用户名不存在。");
        }else if(!u.getStatu()){
            logInfo(request,u.getUserName(),"登录失败尝试登录,账号被冻结");
            return FeedBackConstants.getMessage(false, "您的账号被冻结了,等待管理员处理。");

        }
        LoginCommand command = model;
       // String password = MD5.MD5Encode(command.getPassword().trim());
        UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(),command.getPassword());
        token.setRememberMe(true);
        try{
            if (currentuser.isAuthenticated())
                currentuser.logout();
            SecurityUtils.getSubject().login(token);
            logInfo(request,u.getUserName(),"登录成功");
            return FeedBackConstants.getMessage(true,redirect(currentuser));
        }catch (LockedAccountException e){
            e.printStackTrace();
            return FeedBackConstants.getMessage(false,"账号已经被冻结了");
        }catch (AuthenticationException e){
            e.printStackTrace();
            logInfo(request,u.getUserName(),"登录失败,密码验证不成功");
            return FeedBackConstants.getMessage(false,"用户名或者密码错误");
        }
    }

    /**
     * 用户登录时 根据用户身份，跳转到不同界面
     * @param subject
     * @return
     */
    public String redirect(Subject subject){
        if(subject.hasRole(Constants.ROLE_NAME_ROM)) return "index";
        if(subject.hasRole(Constants.ROLE_NAME_USER) ) return "findphone/index";
        throw new LockedAccountException("you have no roles");     //没有任何身份
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public String register() {
        return "user/register";
    }
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    public Map register(UserRegisterModel model,HttpServletRequest request) {
        UserRegisterModel registerModel = model;
        Users user = userService.findUserByName(registerModel.getUsername());
        if(user!=null){
            Map map = new HashMap();
            map.put(FeedBackConstants.TAG_STATUS,FeedBackConstants.STATUS_FAIL);
            map.put(FeedBackConstants.TAG_MESSAGE, "用户名已经存在");
            return map;
        }
        Users user_info = new Users();
        //String password = MD5.MD5Encode(registerModel.getPassword().trim());
        user_info.setUserName(registerModel.getUsername());
        //user_info.setPassword(password);
        user_info.setEmail(registerModel.getEmail());
        user_info.setTrueName(registerModel.getTrueName());
        user_info.setDept(registerModel.getDept());
        user_info.setPhone(registerModel.getPhone());
        user_info.setStatu(true);  //默认设置为冻结状态  无法登录  需要管理审核
        user_info.setRegDate(new Timestamp(System.currentTimeMillis()));
        //设置密码
        String encrypted = passwordService.encryptPassword(registerModel.getPassword());
        user_info.setPassword(encrypted);

        try{
            userService.save(user_info,Constants.ROLE_USER);  //设置了默认用户身份为 user
          //  SendMail.getInstatnce().sendHtmlMail("用户注册，请审核","有一个用户注册了JSR系统，请审核。<br/><br/>"+"用户名:<a>"+user_info.getUserName()+"</a>",SendMail.getUserName());   //发送邮件到管理员
            logInfo(request,user_info.getUserName(),"注册成功");
            return FeedBackConstants.getMessage(true,"恭喜您,注册成功");
        }catch (Exception e){
            e.printStackTrace();
            return FeedBackConstants.getMessage(true,"注册失败,用户名和邮箱可能已经存在");
        }
    }

    private boolean validateCaptchaImage(HttpServletRequest request) {
        Boolean isResponseCorrect = Boolean.FALSE;
        //remenber that we need an id to validate!
        String captchaId = request.getSession().getId();
        //retrieve the response
        String captcha_value = request.getParameter("captcha_value");
        if(captcha_value == null){
            return true;
        }
        try {
            isResponseCorrect = imageCaptchaService.validateResponseForID(captchaId, captcha_value);
        } catch (CaptchaServiceException e) {
            //should not happen, may be thrown if the id is not valid
        }
        return isResponseCorrect;
    }
    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    public String list(HttpServletRequest request, Model model) {

        setCommonData(model);
        model.addAttribute(Constants.COMMAND, new Users());

        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
        boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre", false);
        Page<Users> page = null;
        if(id > 0) {
            if(pre) {
                page = userService.pre(id, pn);
            }
            else {
                page = userService.next(id, pn);
            }
        }
        else {
            page = userService.listAll(pn);
        }
        request.setAttribute("page", page);
        return "user/list";
    }
    private void setCommonData(Model model) {
        //设置通用属性
    }
    @RequestMapping(value = "/logout")
    public ModelAndView logut(){
        ModelAndView model = new ModelAndView("user/login");
        Subject currentUser = SecurityUtils.getSubject();
        Users users = (Users) currentUser.getSession().getAttribute("currUser");
        currentUser.logout();
        logInfo(users.getUserName(),"成功退出");
        return model;
    }
    @RequestMapping(value = "/user/user_info")
    public  ModelAndView userInfo(){
        ModelAndView modelAndView = new ModelAndView("user/user_info");
        Subject currentUser = SecurityUtils.getSubject();
        Users users = (Users) currentUser.getSession().getAttribute("currUser");
        Users u = userService.get(users.getUserId());
        modelAndView.addObject("currUser",u);
        return modelAndView;
    }
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ModelAndView updateUserInfo(Users users){
        ModelAndView modelAndView = new ModelAndView("redirect:/user/user_info");
        Users u = userService.get(users.getUserId());
        String msg = "";
        if(u != null){
            u.setEmail(users.getEmail());
            u.setDept(users.getDept());
            u.setTrueName(users.getTrueName());
            u.setPhone(users.getPhone());
            try{
                userService.update(u);
                msg = "更新成功";
                logInfo(users.getUserName(),"更新了个人信息");
            }catch (Exception e){
                e.printStackTrace();
                msg = "update fail:"+e.getMessage();
            }
        }
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }
    @RequestMapping(value = "/user/user_password",method = RequestMethod.POST)
    public ModelAndView updatePassword(HttpServletRequest request,RedirectAttributes  redirectAttributes){
        String currentPassword= request.getParameter("curr_password");
        String newPassword= request.getParameter("new_password");
        String confimPassword= request.getParameter("confim_password");
        String msg = "更新失败";
        ModelAndView model = new ModelAndView("redirect:/user/user_info");

        if(currentPassword !=null && newPassword!=null && confimPassword != null){
            Subject currentUser = SecurityUtils.getSubject();
            Users users = (Users) currentUser.getSession().getAttribute("currUser");
            String currPassword =  MD5.MD5Encode(currentPassword.trim());     //当前用户密码
            if(!currPassword.equals(users.getPassword())){
                msg = "当前密码不正确!";
                redirectAttributes.addAttribute("msg", msg);
                //model.addObject("msg",msg);
                return model;
            }

            String password = MD5.MD5Encode(newPassword.trim());

            Users u = userService.get(users.getUserId());
            u.setPassword(password);
            try{
                userService.update(u);
                model.setViewName("redirect:/logut");
                msg = "修改成功，请重新登录";
                logInfo(users.getUserName(),"修改了密码");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        model.addObject("msg", msg);
        return  model;
    }
    @RequestMapping(value = "/user/user_list")
    public ModelAndView userList(){
        ModelAndView model = new ModelAndView("user/user_list");
        List<Users> list = userService.listAll();
        model.addObject("userList",list);
        return model;
    }
    @RequestMapping(value = "/user/lock_user")
    public ModelAndView lockUser(HttpServletRequest request){
        ModelAndView model = new ModelAndView("redirect:/user/user_list");
        String _userId =  request.getParameter("userId");
        String _userState = request.getParameter("userState");
        String msg = "";
        Boolean userState ;
        Users users = (Users) request.getSession().getAttribute("currUser");
        int userId ;
        if(_userId == null || _userId.equals("")){
            msg = "更新失败";
            model.addObject("msg",msg);
            return model;
        }   else{
            userId = Integer.parseInt(_userId);
        }
        if(_userState == null || _userState.equals("")){
            msg = "更新失败";
            model.addObject("msg",msg);
            return model;
        }else{
            userState = Boolean.parseBoolean(_userState);
        }
        Users u = userService.get(userId);
        u.setStatu(!userState);
        userService.update(u);
        msg = "更新成功";
        if(userState){
            logInfo(request,users.getUserName(),"解锁用户"+u.getUserName());
        }else{
            logInfo(request,users.getUserName(),"锁定用户"+u.getUserName());
        }
        model.addObject("msg",msg);
        return model;
    }

    /**
     * 忘记密码,生成找回密码的链接
     * @param request
     * @param username
     * @return
     */
    @RequestMapping(value = "/user/i_forget_password")
    @ResponseBody
    public Map forgetPass(HttpServletRequest request,String username){

        try{
            String path = request.getContextPath();
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            String msg = userService.updateForgetPassword(username,basePath);
            logInfo(request,username,msg);
            return FeedBackConstants.getMessage(true,msg);
        }catch (Exception e){
            e.printStackTrace();
            logInfo(request,username,"申请找回密码失败");
            return FeedBackConstants.getMessage(false,"邮箱不存在？未知错误,联系管理员吧");
        }
    }

    @RequestMapping(value = "/user/reset_password",method = RequestMethod.POST)
    @ResponseBody
    public Map resetPwd(String userName,String password,String passwordConfirm){
        if(password == null || password.equals("") || passwordConfirm==null || passwordConfirm.equals("")){
            return FeedBackConstants.getMessage(false,"密码和确认密码不能为空");
        }
        if(!password.equals(passwordConfirm)){
            return FeedBackConstants.getMessage(false,"两次输入的密码不相等");
        }
        try{
            Users users = userService.findUserByName(userName);
            if(users == null){
                return FeedBackConstants.getMessage(false,"用户名不存在");
            }
            String pass = MD5.MD5Encode(password);
            users.setPassword(pass);
            users.setRegDate(null);
            users.setValidataCode("");
            userService.update(users);
            logInfo(userName,"通过找回密码,重新设置密码成功");
            return FeedBackConstants.getMessage(true,"修改成功,3秒后跳转到登录界面;。");
        }catch (Exception e){
            e.printStackTrace();
            logInfo(userName,"通过找回密码,重新设置密码失败");
            return FeedBackConstants.getMessage(false,"密码修改失败");
        }
    }

    /**
     * 验证重置密码的链接是否正确
     * @param sid
     * @param userName
     * @return
     */
    @RequestMapping(value = "/user/reset_password",method = RequestMethod.GET)
    public ModelAndView checkResetLink(String sid,String userName){
        ModelAndView model = new ModelAndView("error");
        String msg = "";
        if(sid.equals("") || userName.equals("")){
            msg="链接不完整,请重新生成";
            model.addObject("msg",msg) ;
            logInfo(userName,"找回密码链接失效");
            return model;
        }
        Users users = userService.findUserByName(userName);
        if(users == null){
            msg = "链接错误,无法找到匹配用户,请重新申请找回密码.";
            model.addObject("msg",msg) ;
            logInfo(userName,"找回密码链接失效");
            return model;
        }
        Timestamp outDate = users.getRegDate();
        //logger.info(outDate.getTime()+"\t"+System.currentTimeMillis());
        if(outDate.getTime() <= System.currentTimeMillis()){         //表示已经过期
            msg = "链接已经过期,请重新申请找回密码.";
            model.addObject("msg",msg) ;
            logInfo(userName,"找回密码链接失效");
            return model;
        }
        String key = users.getUserName()+"$"+outDate.getTime()/1000*1000+"$"+users.getValidataCode();          //数字签名
        String digitalSignature = MD5.MD5Encode(key);
        //System.out.println(key+"\t"+digitalSignature);
        if(!digitalSignature.equals(sid)) {
            msg = "链接不正确,是否已经过期了?重新申请吧";
            model.addObject("msg",msg) ;
            logInfo(userName,"找回密码链接失效");
            return model;
        }
        model.setViewName("user/reset_password");  //返回到修改密码的界面
        model.addObject("userName",userName);
        return model;
    }

    public void logInfo(HttpServletRequest request,String userName,String msg){
        MDC.put("user_name",userName);
        MDC.put("manu_ip", request.getRemoteAddr());
        logger.info(msg);
    }
    public void logInfo(String userName,String msg){
        MDC.put("user_name",userName);
        logger.info(msg);
    }

}
