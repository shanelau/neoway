package cn.neoway.cloud.controller;

import cn.neoway.cloud.bean.SysEmail;
import cn.neoway.cloud.service.PlanUserService;
import cn.neoway.cloud.service.SysEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author Zhangkaitao
 * @version 1.0
 */
@Controller("indexController")
public class IndexController {
    @Autowired
    @Qualifier("PlanUserService")
    PlanUserService planUserService;

    @Autowired
    @Qualifier("SysEmailService")
    SysEmailService sysEmailService;
    
    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView model = new ModelAndView("index");
        List list = planUserService.getRecentlListByType(1,10);
        model.addObject("dealList",list);
        return model;
    }
    @RequestMapping(value = "/plan/create_module_plan")
    public String planDealList(){
        return "plan/create_module_plan";
    }
    @RequestMapping(value = "/user_advice")
    public ModelAndView userAdvice(){
        ModelAndView model = new ModelAndView("user_advice");
        List<SysEmail> adviceList =  sysEmailService.listAll();
        model.addObject("adviceList",adviceList);
        return model;
    }


}
