package cn.neoway.cloud.controller;


import cn.neoway.cloud.model.LoginCommand;
import com.octo.captcha.service.CaptchaServiceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ModelAndView list( LoginCommand model, HttpServletRequest request) {
        ModelAndView mav= new ModelAndView();
       boolean isResponseCorrect  = validateCaptchaImage(request);
       if(!isResponseCorrect){      //验证失败
           mav.setViewName("login");
           mav.addObject("error_info","验证码错误");
           mav.addObject("error_time",1);
           return mav;
       }

        LoginCommand command = model;
        UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(),command.getPassword());
        System.out.print(command.getUsername()+"\t"+command.getPassword());
        try{
        SecurityUtils.getSubject().login(token );
        mav.setViewName("index");

        }catch (AuthenticationException e){

            mav.setViewName("login");
            mav.addObject("error_info","用户名或者密码错误");
            mav.addObject("error_time",1);
        }
        return  mav;
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
