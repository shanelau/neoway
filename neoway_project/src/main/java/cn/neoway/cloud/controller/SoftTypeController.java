package cn.neoway.cloud.controller;

import cn.neoway.cloud.bean.ProSoftList;
import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.cloud.bean.SoftwareType;
import cn.neoway.cloud.service.ProSoftListService;
import cn.neoway.cloud.service.ProjectService;
import cn.neoway.cloud.service.SoftwareInfoService;
import cn.neoway.cloud.service.SoftwareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-11
 * Time: 下午3:56
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SoftTypeController {
    @Autowired
    @Qualifier("ProjectService")
    ProjectService projectService;
    @Autowired
    @Qualifier("SoftwareInfoService")
    SoftwareInfoService softwareInfoService;
    @Autowired
    @Qualifier("SoftwareTypeService")
    SoftwareTypeService softwareTypeService;
    @Autowired
    @Qualifier("ProSoftListService")
    ProSoftListService proSoftListService;

    @RequestMapping(value = "/plan/add_soft_type")
    public void addSoftType(HttpServletRequest request,HttpServletResponse response){
        String typeName=  request.getParameter("typeName");
        String  _proPlanId  = request.getParameter("proPlanId");
        String msg = "";
        if(typeName.equals("") || typeName == null){
            msg = "类别名不能为空";
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.print(msg);
            } catch (IOException e) {
                writer.close();
            }
         }else{
        int proPlanId = Integer.parseInt(_proPlanId);
        SoftwareType softwareType = new SoftwareType();
        softwareType.setSoftTypeName(typeName);
        SoftwareInfo softInfo = new SoftwareInfo();
        softInfo.setSoftName("无软件");
        softInfo.setSoftRemark("未指定软件");
        softInfo.setSoftwareTypeBySoftTypeId(softwareType);

        Project project = projectService.get(proPlanId);
        ProSoftList proSoftList = new ProSoftList();
        proSoftList.setProjectByProPlanId(project);
        proSoftList.setSoftwareInfoByProSoftwareId(softInfo);
        try{
            proSoftListService.save(proSoftList);
            msg = "软件类别插入成功,页面正在刷新.";
        }catch (Exception e){
            e.printStackTrace();
            msg = "插入失败";
        }

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(msg);
        } catch (IOException e) {
            writer.close();
        }
    }
    }
}
