package cn.neoway.cloud.controller;

import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.service.PlanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-26
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class PlanListController {
    @Autowired
    @Qualifier("PlanUserService")
    PlanUserService planUserService;

    @RequestMapping(value = "/plan/plan-list-deal")
    public ModelAndView getDealPlan(){
        ModelAndView model = new ModelAndView("plan/plan-list-deal");
        List list = null;
        try{
        list = planUserService.getDealProjectList();
        }catch (Exception e){
            e.printStackTrace();
        }
            model.addObject("dealList",list);
        return model;
    }
    @RequestMapping(value = "/plan/plan-list-finish")
    public ModelAndView getFinshPlan(){
        ModelAndView model = new ModelAndView("plan/plan-list-finish");
        List<Project> list = planUserService.getFinishProjectList();
        model.addObject("dealList",list);
        return model;
    }
}
