package cn.neoway.cloud.controller;

import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.cloud.bean.SoftwareType;
import cn.neoway.cloud.bean.Users;
import cn.neoway.cloud.service.SoftwareTypeService;
import cn.neoway.cloud.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-25
 * Time: 下午1:50
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AutoComplementController {
    @Autowired
    @Qualifier("SoftwareTypeService")
    SoftwareTypeService softwareTypeService;

    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;

    @RequestMapping(value = "/plan/getSoftList",method = RequestMethod.POST)
    public ModelAndView getSoftInfo(HttpServletRequest request){
        ModelAndView model = new ModelAndView("plan/module_plan");
        String _soft_type = request.getParameter("soft_type");
        int softType = Integer.parseInt(_soft_type);
        SoftwareType softwareType = softwareTypeService.get(softType);
        List list = new ArrayList<SoftwareInfo>();
        Collection<SoftwareInfo> set = softwareType.getSoftwareInfosBySoftTypeId();
        for(SoftwareInfo softwareInfo :set){
            softwareInfo.setSoftwareTypeBySoftTypeId(null);
            softwareInfo.setProSoftListsByProSoftwareId(null);
            list.add(softwareInfo);
        }
        model.addObject("softWareList",list);
        return model;
    }
    @RequestMapping(value = "/plan/geUsers",method = RequestMethod.POST)
    public ModelAndView getUsersList(HttpServletRequest request){
        String keyword = request.getParameter("keyword");
        List<Users> userList = null;
        if(keyword == null || keyword.trim().equals("")) {
            userList = userInfoService.listAll();
        }else{
            userList = userInfoService.listByKeyword(keyword.trim());
        }
        ModelAndView model = new ModelAndView("plan/create_module_plan");
        for(Users users :userList){
            users.setUserRolesesByUserId(null);
            users.setPlanUsersByUserId(null);
            users.setManuLogsByUserId(null);
        }
        model.addObject("userList",userList);
        return model;
    }
}