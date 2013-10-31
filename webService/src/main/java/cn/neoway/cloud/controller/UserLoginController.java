package cn.neoway.cloud.controller;


import cn.neoway.cloud.bean.Users;
import cn.neoway.cloud.model.LoginCommand;
import cn.neoway.cloud.model.UserQueryModel;
import cn.neoway.cloud.model.UserRegisterModel;
import cn.neoway.cloud.service.UserInfoService;
import cn.neoway.common.Constants;
import cn.neoway.common.pagination.Page;
import cn.neoway.common.shiro.realm.MD5;
import cn.neoway.common.web.support.editor.DateEditor;
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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-10
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserLoginController {
    @Autowired
    @Qualifier("imageCaptchaService")
    private com.octo.captcha.service.image.ImageCaptchaService imageCaptchaService;
    @Autowired
    @Qualifier("userService")
    private UserInfoService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ModelAndView login(LoginCommand model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        int times = 0;
        Session session = SecurityUtils.getSubject().getSession();     //用户session
        Object obj = session.getAttribute("login_fail_times");       //三次密码输入错误 ，出现验证码
        if (obj != null)
            times = (int) obj;
        boolean isResponseCorrect = validateCaptchaImage(request);
        isResponseCorrect = true;
        if (!isResponseCorrect) {      //验证失败
            mav.setViewName("login");
            mav.addObject("error_info", "验证码错误");
            mav.addObject("login_fail_times", times);
            return mav;
        }
        LoginCommand command = model;
        String password = MD5.MD5Encode(command.getPassword().trim());
        UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), password);
        token.setRememberMe(true);
        try {

            SecurityUtils.getSubject().login(token);
            mav.setViewName("index");

        } catch (AuthenticationException e) {
            e.printStackTrace();
            times++;
            mav.setViewName("login");
            mav.addObject("error_info", "用户名或者密码错误1");
            mav.addObject("login_fail_times", times);
        }
        session.setAttribute("login_fail_times", times);
        return mav;
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
        if (user != null) {
            mv.addObject("error_msg", "用户名已经存在。");
            mv.setViewName("register");
            return mv;
        }
        Users user_info = new Users();
        String password = MD5.MD5Encode(registerModel.getPassword().trim());
        user_info.setUserName(registerModel.getUsername());
        user_info.setPassword(password);
        user_info.setEmail(registerModel.getEmail());
        user_info.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        userService.save(user_info);
        mv.setViewName("index");
        return mv;
    }

    private boolean validateCaptchaImage(HttpServletRequest request) {
        Boolean isResponseCorrect = Boolean.FALSE;
        //remenber that we need an id to validate!
        String captchaId = request.getSession().getId();
        //retrieve the response
        String captcha_value = request.getParameter("captcha_value");
        if (captcha_value == null) {
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
        if (id > 0) {
            if (pre) {
                page = userService.pre(id, pn);
            } else {
                page = userService.next(id, pn);
            }
        } else {
            page = userService.listAll(pn);
        }
        request.setAttribute("page", page);
        return "user/list";
    }

    private void setCommonData(Model model) {
        //设置通用属性
    }

}
