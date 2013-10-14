package cn.neoway.cloud.controller;


import cn.neoway.cloud.bean.Users;
import cn.neoway.cloud.model.LoginCommand;
import cn.neoway.cloud.model.UserRegisterModel;
import cn.neoway.cloud.service.UserInfoService;
import cn.neoway.common.Constants;
import cn.neoway.common.mail.SendMail;
import cn.neoway.common.pagination.Page;
import cn.neoway.common.shiro.realm.MD5;
import com.octo.captcha.service.CaptchaServiceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-10
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserLoginController{
    @Autowired
    @Qualifier("imageCaptchaService")
    private com.octo.captcha.service.image.ImageCaptchaService imageCaptchaService;
    @Autowired
    @Qualifier("UserInfoService")
    private UserInfoService userService;

    @RequestMapping(value = "/login_register", method = RequestMethod.GET)
    public String login() {
        return "login_register";
    }
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ModelAndView login( LoginCommand model, HttpServletRequest request) {
        ModelAndView mav= new ModelAndView("login_register");

        int times = 0;
        Session session = SecurityUtils.getSubject().getSession();     //用户session
        Object obj = session.getAttribute("login_fail_times");       //三次密码输入错误 ，出现验证码
        if(obj!=null)
            times = (int) obj;
       boolean isResponseCorrect  = validateCaptchaImage(request);
        isResponseCorrect = true;
       if(!isResponseCorrect){      //验证失败
           mav.setViewName("login_register");
           mav.addObject("error_info","验证码错误");
           mav.addObject("login_fail_times",times);
           return mav;
       }
        //检查是否被冻结
        Users u = userService.findUserByName(model.getUsername());
        if( u == null){
            mav.addObject("error_info","用户名不存在。");
            return mav;
        }else if(!u.getUserState()){
            mav.setViewName("login_register");
            mav.addObject("error_info","您的账号被冻结了,等待管理员处理。");
            return mav;
        }
        LoginCommand command = model;
        String password = MD5.MD5Encode(command.getPassword().trim());
        UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(),password);
        token.setRememberMe(true);
        try{

        SecurityUtils.getSubject().login(token );
        mav.setViewName("redirect:index");

        }catch (AuthenticationException e){
            e.printStackTrace();
            times++;
            mav.setViewName("login_register");
            mav.addObject("error_info","用户名或者密码错误");
            mav.addObject("login_fail_times",times);
        }
        session.setAttribute("login_fail_times",times);
        return  mav;
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public String register() {
        return "register";
    }
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ModelAndView register(UserRegisterModel model) {
        UserRegisterModel registerModel = model;
        ModelAndView mv = new ModelAndView();
        Users user = userService.findUserByName(registerModel.getUsername());
        if(user!=null){
            mv.addObject("error_info","用户名已经存在。");
            mv.setViewName("login_register");
            return mv;
        }
        Users user_info = new Users();
        String password = MD5.MD5Encode(registerModel.getPassword().trim());
        user_info.setUserName(registerModel.getUsername());
        user_info.setPassword(password);
        user_info.setEmail(registerModel.getEmail());
        user_info.setUserState(false);  //默认设置为冻结状态  无法登录  需要管理审核
        user_info.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        String error_info = "";
        try{
            userService.save(user_info);
            error_info = "注册成功,等待管理员审核。";
            SendMail.getInstatnce().sendHtmlMail("用户注册，请审核","有一个用户注册了有方生产数据系统，请审核。<br/><br/>"+"用户名:<a>"+user_info.getUserName()+"</a>",SendMail.getUserName());   //发送邮件到管理员
        }catch (Exception e){
            e.printStackTrace();
            error_info ="注册失败,用户名和邮箱可能已经存在";
        }
        mv.addObject("error_info",error_info);
        mv.setViewName("login_register");
        return mv;
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
    @RequestMapping(value = "/logut")
    public ModelAndView logut(){
        ModelAndView model = new ModelAndView("login_register");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return model;
    }
    @RequestMapping(value = "/user_info")
    public  ModelAndView userInfo(){
        ModelAndView modelAndView = new ModelAndView("user_info");
        Subject currentUser = SecurityUtils.getSubject();
        Users users = (Users) currentUser.getSession().getAttribute("currUser");
        Users u = userService.get(users.getUserId());
        modelAndView.addObject("currUser",u);
        return modelAndView;
    }
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ModelAndView updateUserInfo(Users users){
        ModelAndView modelAndView = new ModelAndView("redirect:/user_info");
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
            }catch (Exception e){
                e.printStackTrace();
                msg = "update fail:"+e.getMessage();
            }
        }
        modelAndView.addObject("user_update_msg",msg);
        return modelAndView;
    }
    @RequestMapping(value = "/user_password",method = RequestMethod.POST)
    public ModelAndView updatePassword(HttpServletRequest request,RedirectAttributes  redirectAttributes){
        String currentPassword= request.getParameter("curr_password");
        String newPassword= request.getParameter("new_password");
        String confimPassword= request.getParameter("confim_password");
        String msg = "更新失败";
        ModelAndView model = new ModelAndView("redirect:/user_info");

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
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        model.addObject("msg", msg);
        return  model;
    }
    @RequestMapping(value = "/user_list")
    public ModelAndView userList(){
        ModelAndView model = new ModelAndView("user_list");
        List<Users> list = userService.listAll();
        model.addObject("userList",list);
        return model;
    }
    @RequestMapping(value = "/lock_user")
    public ModelAndView lockUser(HttpServletRequest request){
        ModelAndView model = new ModelAndView("redirect:user_list");
        String _userId =  request.getParameter("userId");
        String _userState = request.getParameter("userState");
        String msg = "";
        Boolean userState ;
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
        u.setUserState(!userState);
        userService.update(u);
        msg = "更新成功";
        model.addObject("msg",msg);
        return model;
    }

}
