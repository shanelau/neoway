package cn.neoway.cloud.controller;


import cn.neoway.cloud.bean.Users;
import cn.neoway.cloud.model.LoginCommand;
import cn.neoway.cloud.model.UserRegisterModel;
import cn.neoway.cloud.service.UserInfoService;
import com.octo.captcha.service.CaptchaServiceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-10
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserLoginController{
    @Resource(name = "imageCaptchaService")
    private com.octo.captcha.service.image.ImageCaptchaService imageCaptchaService;
    @Autowired
    @Qualifier("userInfoService")
    private UserInfoService userInfoService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ModelAndView list( LoginCommand model, HttpServletRequest request) {
        ModelAndView mav= new ModelAndView();

        int times = 0;
        Session session = SecurityUtils.getSubject().getSession();     //用户session
        Object obj = session.getAttribute("login_fail_times");       //三次密码输入错误 ，出现验证码
        if(obj!=null)
            times = (int) obj;
       boolean isResponseCorrect  = validateCaptchaImage(request);
       if(!isResponseCorrect){      //验证失败
           mav.setViewName("login");
           mav.addObject("error_info","验证码错误");
           mav.addObject("login_fail_times",times);
           return mav;
       }
        LoginCommand command = model;
        UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(),command.getPassword());
        token.setRememberMe(true);
        try{

        SecurityUtils.getSubject().login(token );
        mav.setViewName("index");

        }catch (AuthenticationException e){
            e.printStackTrace();
            times++;
            mav.setViewName("login");
            mav.addObject("error_info","用户名或者密码错误1");
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
        Users user = userInfoService.findUserByName(registerModel.getUsername());
        if(user!=null){
            mv.addObject("error_msg","用户名已经存在。");
            mv.setViewName("register");
            return mv;
        }
        Users user_info = new Users();
        PasswordService svc = new DefaultPasswordService();
        String encrypted = svc.encryptPassword(registerModel.getPassword());
        user_info.setUserName(registerModel.getUsername());
        user_info.setPassword(encrypted);
        user_info.setEmail(registerModel.getEmail());
        userInfoService.save(user_info);
        mv.setViewName("index");
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

}
