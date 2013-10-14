package cn.neoway.cloud.controller;

import cn.neoway.cloud.bean.*;
import cn.neoway.cloud.model.ProjectModel;
import cn.neoway.cloud.service.*;
import cn.neoway.common.Constants;
import cn.neoway.common.mail.SendMail;
import cn.neoway.common.util.FileUploadUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-23
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class PlanController {

    @Autowired
    @Qualifier("PlanUserService")
    PlanUserService planUserService;
    @Autowired
    CommonsMultipartResolver multipartResolver;


    @Autowired
    @Qualifier("ProjectService")
    ProjectService projectService;
    @Autowired
    @Qualifier("PlanUserTypeService")
    PlanUserTypeService planUserTypeService;
    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;
    @Autowired
    @Qualifier("ProStatetTypeService")
    ProStatetTypeService proStateTypeService;
    @Autowired
    @Qualifier("SoftwareInfoService")
    SoftwareInfoService softwareInfoService;
    @Autowired
    @Qualifier("SoftwareTypeService")
    SoftwareTypeService softwareTypeService;
    @Autowired
    @Qualifier("ProSoftListService")
    ProSoftListService proSoftListService;
    private String currentUser;


    @RequestMapping(value = "/plan/module-plan-editor")
    public ModelAndView editorPlan(HttpServletRequest request){
        ModelAndView model = new ModelAndView("plan/module_plan");
        String modulId = request.getParameter("moduleId");
        String msg = "";
        msg = request.getParameter("msg");
        if(modulId!=null && !modulId.equals("")){
                try {
                    modulId = new String(modulId.getBytes("ISO8859-1"),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            Project project = projectService.findByModuleProId(modulId.trim());
            project.setPlanUsersByProPlanId(null);


            //基本信息
            List<PlanUser> planUserList = planUserService.getUserListByProjectId(project.getProPlanId());
            //project.setPlanUsersByProPlanId(planUserList);
            List<String> uselist = new ArrayList<>();
            Subject currentUser = SecurityUtils.getSubject();
            Users users = (Users) currentUser.getSession().getAttribute("currUser"); //当前登录的用户
            int current_user_type_id = -1;

            Map userMap = new HashMap();
            for(PlanUser pu : planUserList){
               String key =  pu.getPlanUserTypeByPlanUserTypeId().getPlanUserTypeName();
               Users u = pu.getUsersByUserId();
               if(u.getUserName().equals(users.getUserName())){
                   current_user_type_id = pu.getPlanUserTypeByPlanUserTypeId().getPlanUserTypeId();  //当前用户在改 计划单的 类型id
               }
               String value = u.getUserName();
                userMap.put(key,value);
                pu.setProjectByProPlanId(null);
                uselist.add(pu.getUsersByUserId().getUserName());
            }

            model.addObject("planUserList",planUserList) ;
            model.addObject("uselist",uselist);
            model.addObject("userTypeId",current_user_type_id);
            //配置文件

            //软件信息列表
            List<ProSoftList> softList = proSoftListService.findByProPlanId(project.getProPlanId());
            //软件列表列表
            List<SoftwareType> softTypeList = softwareTypeService.listAll();

            //生产信息
           ManuInfo mi = project.getManuInfoByManuInfoId();
            Boolean[] proces = null;
            if(mi!=null){
                String proce = mi.getManuProcedure();

                if(proce != null && !proce.equals("")){
                    proces = new Boolean[6];
                    for(int i = 1;i <= 6;i++){
                        if(proce.contains(i+"")){
                            proces[i-1]=true;
                        }else{
                            proces[i-1] = false;
                        }
                    }
                }
            }
            model.addObject("project",project);
            model.addObject("userMap",userMap);
            model.addObject("softList",softList);
            model.addObject("softTypeList",softTypeList);
            model.addObject("proces",proces);
           model.addObject("msg",msg);
        }else{
              //错误页面
        }
        String view = request.getParameter("is_view");      //跳转到预览页面
        if(view!=null && !view.equals("")){
            model.setViewName("plan/module_plan_view");
        }
         return model;
    }
    @RequestMapping(value = "/plan/update_module_base",method = RequestMethod.POST)
    public ModelAndView updateBase(ProjectModel projectModel,HttpServletRequest request,HttpServletResponse response){
        ModelAndView model = new ModelAndView("redirect:plan-list-deal");
        String msg = "未知错误";
        try{
            projectService.updateProject(projectModel, Constants.PLAN_STATE_BASE);
            msg = "计划单创建成功";
        }catch (Exception e){
            e.printStackTrace();
            msg =  "插入失败.人员信息不能相同,点击浏览器的返回键";
            model.setViewName("plan/create_module_plan");
        }
        model.addObject("msg",msg);
        return model;
    }
    @RequestMapping(value = "/plan/create_module_base",method = RequestMethod.POST)
    public ModelAndView saveBase(ProjectModel projectModel,HttpServletRequest request,HttpServletResponse response){
        ModelAndView model = new ModelAndView("redirect:plan-list-deal");
        String msg = "未知错误";
        try{
            savePlanInfo(projectModel, Constants.PLAN_STATE_BASE);
            msg = "计划单创建成功";
        }catch (Exception e){
            e.printStackTrace();
            msg =  "插入失败.人员信息不能相同,点击浏览器的返回键";
            model.setViewName("plan/create_module_plan");
        }
        model.addObject("msg",msg);
        return model;
    }
    //建立新的计划单
    public void savePlanInfo(ProjectModel projectModel, int stateTypeId){
        Users[] ayy = projectService.getUser(projectModel);
        Project project1 = projectService.getProject(projectModel);
        ProStateType proStateTyp = projectService.getProjectState(stateTypeId);
        project1.setProStateTypeByProPlanStateId(proStateTyp);

        //插入软件信息
        int softTypeCount = softwareTypeService.countAll();          //软件类别数目
        List<SoftwareInfo> softwareInfoList = softwareInfoService.getNullFileByTypeId();           //保正数据库存在默认的信息
        List list = new ArrayList();
        for(int i=1; i <= softTypeCount ;i++){
            ProSoftList  proSoftList = new ProSoftList();
            proSoftList.setSoftwareInfoByProSoftwareId(softwareInfoList.get(i-1));
            proSoftList.setProjectByProPlanId(project1);
            list.add(proSoftList);
        }
        project1.setProSoftListsByProjectId(list);

        //软件信息结束
        for(int i=1;i<=ayy.length;i++){
            PlanUser newPu = new PlanUser();
            newPu.setProjectByProPlanId(project1);
            if( i == stateTypeId){
                newPu.setDealAdvice("我已经填写完毕,等待提交");
                String user = projectModel.getProCreateUser();
                if(user!=null && !user.equals("")){
                    user = user.split(",")[0];
                }
                newPu.setDealUser(user);       //这次处理的人
                newPu.setPass(false);
                newPu.setDealTime(new Timestamp(System.currentTimeMillis()));
            }
            newPu.setPlanUserTypeByPlanUserTypeId(planUserTypeService.get(i));
            newPu.setUsersByUserId(ayy[i - 1]);
            //planUserList.add(newPu);
            planUserService.save(newPu);
        }
    }

    public void pringtoJson(Object obj){
        JSONObject object = JSONObject.fromObject(obj);
        System.out.print(object.toString());
    }




    @RequestMapping(value = "/plan/create_conf", method = RequestMethod.POST)
    public ModelAndView addConf(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        String msg = "";
        String moduleProId = request.getParameter("moduleProId");
        String remark = request.getParameter("remark");
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String[] filename = fileUploadUtil.uploadConfig(multipartRequest, multipartResolver);
        ConfInfo confInfo = new ConfInfo();
        confInfo.setUploadDate(new Timestamp(System.currentTimeMillis()));
        confInfo.setRemark(remark);
        confInfo.setConfFileName(filename[0]);
        confInfo.setConfPath(filename[1]);
        Project project = projectService.findByModuleProId(moduleProId);
        if (project == null) {
            msg = "上传出错";
        } else {
            project.setConfInfoByConfFileId(confInfo);
            try {
                projectService.update(project);
                msg = "配置文件上传成功";
            } catch (Exception e) {
                e.printStackTrace();
                msg = "上传出错";
            }
        }
        model.setViewName("redirect:module-plan-editor");
        model.addObject("moduleId",moduleProId);
        model.addObject("msg", msg);
        return model;
    }

    /**
     * 修改 planUser表    审批流程
     * @param request
     */
    @RequestMapping(value = "/plan/shenpi")
    public ModelAndView addPlanUserState(HttpServletRequest request){
        ModelAndView model = new ModelAndView("module-plan-editor");
        String msg = "";
        String _planUserListId = request.getParameter("planUserListId1");
        String _isPass = request.getParameter("isPass");
        String dealAdvice = request.getParameter("dealAdvice");
        String dealUser = request.getParameter("dealUser");
        String _currState = request.getParameter("currState");
        String title = "计划单处理通知";
        String content = "";
        String toAddress = ""; //接收人的email
        Boolean  result  = false;
        try{
        if(_planUserListId !=null && !_planUserListId.equals("")){
            Integer planUserId = Integer.parseInt(_planUserListId);
            Boolean isPass = Boolean.parseBoolean(_isPass);
            Integer currState = Integer.parseInt(_currState);
            PlanUser pu = planUserService.get(planUserId);
            PlanUser dealPu ;
            if(isPass){                                                                        //如果同意了  直接由下一个人处理  状态设置为 +1
                pu.setPass(true);
                pu.getProjectByProPlanId().getProStateTypeByProPlanStateId().setProPlanStateId(currState + 1);                //设置project的状态
                if(currState < Constants.PLAN_STATE_CHEKC_SOFT ){
                    dealPu = planUserService.findDealUser(planUserId, currState + 1); //根据状态获取需要处理该计划单的 用户
                    dealUser = dealPu.getUsersByUserId().getUserName();
                    //计划单处理流程
                    content = "计划单：<a style='color:#ff0000'>"+pu.getProjectByProPlanId().getModuleProId()+"</a>等待"+dealUser+"进行下一步操作。" +
                            "<br/>请登录有方生产数据系统进行操作";
                    toAddress = dealPu.getUsersByUserId().getEmail();
                } else{
                    dealUser = "";
                    //计划单完成
                }
                pu.setDealTime(new Timestamp(System.currentTimeMillis()));
                pu.setDealAdvice("处理顺序，轮到您处理了");
                pu.setDealUser(dealUser);
                pu.update();
            }else{
                dealPu =  planUserService.findDealUser(planUserId , dealUser);          //下一步需要处理的PlanUser 对象
                pu.setPass(false);
                pu.setDealAdvice(dealAdvice);
                pu.setDealUser(dealUser);
                int stateId = dealPu.getPlanUserTypeByPlanUserTypeId().getPlanUserTypeId();           //设置计划单状态 == 处理用户状态
                pu.getProjectByProPlanId().getProStateTypeByProPlanStateId().setProPlanStateId(stateId);
                pu.update();
                //审批不通过，发邮件给 需要处理该计划单的人
                content = "您的计划单审批没有通过。<br/><br/>审批人:"+pu.getUsersByUserId().getUserName()+";<br/>审批意见:"+dealAdvice+"。<br/><br/>请登录有方生产数据系统进行操作";
                toAddress = dealPu.getUsersByUserId().getEmail();
            }
            msg = (dealUser.equals(""))?"提交成功。":"保存成功。等待"+dealUser+" 处理";
            result = true;
             //开始发邮件
            try {
                SendMail.getInstatnce().sendHtmlMail(title,content,toAddress);
            } catch (Exception e){
                e.printStackTrace();
                msg = "用户注册的邮箱"+toAddress+"不存在,通知邮件发送失败.";
            }
        }else {
            msg = "提交出错";
        }
        }catch (Exception e){
            e.printStackTrace();
            msg = "保存出错";
        }
        model.addObject("result",result);
        model.addObject("msg",msg);
        return model;
    }


    /**
     *  上传软件
     * @param request
     * @param response
     */
    @RequestMapping(value = "/plan/up_file",method = RequestMethod.POST)
    public void addSoftInfo(HttpServletRequest request,HttpServletResponse response){
        String msg = "";
        ModelAndView model = new ModelAndView("redirect:module-plan-editor");
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        String obj = request.getParameter("soft_type_id");
        String reMark = request.getParameter("reMark");

        int type_id = Integer.parseInt(obj);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        SoftwareInfo softInfo = fileUploadUtil.upLoad(type_id, multipartRequest, multipartResolver);
        if(softInfo == null){
            msg = "保存出错";
        }else{
            try{
                SoftwareType softwareType = softwareTypeService.get(type_id);
                softInfo.setSoftwareTypeBySoftTypeId(softwareType);
                softInfo.setSoftRemark(reMark);
                softwareInfoService.save(softInfo);
                msg = "文件上传成功";
            }catch (Exception e){
                msg = "上传出错";
            }
        }

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(msg);
        } catch (IOException e) {
            writer.close();
        }

    }

    @RequestMapping(value = "/plan/create_smt",method = RequestMethod.POST)
    public ModelAndView addSMT(SmtTiepianInfo smtTiepianInfo,HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        String msg = "";
        String moduleProId =  request.getParameter("moduleProId");
        Project project = projectService.findByModuleProId(moduleProId);
        if(project == null){
            msg = "提交出错";
        }else{
            smtTiepianInfo.setSmtDate(new Timestamp(System.currentTimeMillis()));
            project.setSmtTiepianInfoBySmtId(smtTiepianInfo);
            try{
               /* ProStateType proStateTyp = getProjectState(3);             //设置状态为创建SMT
                project.setProStateTypeByProPlanStateId(proStateTyp);*/
                project.update();
                msg = "SMT贴片信息提交成功";
            }catch (Exception e){
                e.printStackTrace();
                msg = "提交出错";
            }
        }
        model.setViewName("redirect:module-plan-editor");
        model.addObject("moduleId",moduleProId);
        model.addObject("msg",msg);
        return model;
    }

    @RequestMapping(value = "/plan/create_manu",method = RequestMethod.POST)
    public ModelAndView addManuInf(HttpServletRequest request){
        String moduleProId =  request.getParameter("moduleProId");
        String[] proAyy =  request.getParameterValues("manuProcedure") ;
        String proProcedure ="";
        String _manuState =  request.getParameter("manuState");
        String _isReback =  request.getParameter("isReback");
        String _rebackInfo =  request.getParameter("rebackInfo");
        String _updateInfo =  request.getParameter("updateInfo");
        String _isBackCheck =  request.getParameter("isBackCheck");
        String _manuNotice =  request.getParameter("manuNotice");

       if(proAyy.length == 1){
           //没有选择
       } else{
           for (int i = 0; i<proAyy.length;i++){
               proProcedure+=proAyy[i];
           }
       }
        boolean isReback = Boolean.parseBoolean(_isReback);
        boolean isBackCheck  = Boolean.parseBoolean(_isBackCheck);
        ManuInfo manuInfo = new ManuInfo();
        manuInfo.setUpdateInfo(_updateInfo);
        manuInfo.setRebackInfo(_rebackInfo);
        manuInfo.setBackCheck(isBackCheck);
        manuInfo.setManuInfoDate(new Timestamp(System.currentTimeMillis()));
        manuInfo.setManuState(_manuState);
        manuInfo.setManuNotice(_manuNotice);
        manuInfo.setManuProcedure(proProcedure);
        manuInfo.setReback(isReback);

        Project project = projectService.findByModuleProId(moduleProId);


        ModelAndView model = new ModelAndView();
        String msg = "";
        if(project == null){
            msg = "提交出错";
        }else{
            try{
                project.setManuInfoByManuInfoId(manuInfo);
                projectService.update(project);
                msg = "生产信息提交成功";
            }catch (Exception e){
                e.printStackTrace();
                msg = "提交出错,点击浏览器的后退键";
            }
        }
        model.setViewName("redirect:module-plan-editor");
        model.addObject("moduleId",moduleProId);
        model.addObject("msg",msg);
        return model;
    }
    @RequestMapping(value = "/plan/add_soft_list",method = RequestMethod.POST)
    public ModelAndView addSoftList(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        String moduleProId =  request.getParameter("moduleProId");
        String msg = "";
        Project project = projectService.findByModuleProId(moduleProId);
        if(project == null){
            msg = "提交出错";
        }else{
            String[] softIds = request.getParameterValues("soft_id");
            ArrayList list = new ArrayList();
            for(String str : softIds){
                if(str!=null&&!str.equals("")){
                    int softId =  Integer.parseInt(str);
                    if(softId!=0){
                        SoftwareInfo softwareInfo = softwareInfoService.get(softId);
                        ProSoftList  proSoftList = new ProSoftList();
                        proSoftList.setSoftwareInfoByProSoftwareId(softwareInfo);
                        proSoftList.setProjectByProPlanId(project);
                        list.add(proSoftList);
                    }
                }
            }
        if(list.size()>0){
                try{
                     proSoftListService.saveProList(project.getProPlanId(),list);
                    msg = "保存成功";
                }catch (Exception e){
                    e.printStackTrace();
                    msg = "提交出错";
                }
            }
        }
        model.setViewName("redirect:module-plan-editor");
        model.addObject("moduleId",moduleProId);
        model.addObject("msg",msg);
        return model;
    }

    public String getCurrentUser() {
        return "session 获取当前用户";
    }
    @RequestMapping(value = "/plan/delete")
    public String deletePlan(HttpServletRequest request){
        String moduleId = request.getParameter("moduleId");
        if(moduleId != null && !moduleId.equals("")){
            Project   project =   projectService.get(Integer.parseInt(moduleId));
            projectService.deleteObject(project);          //删除计划单
           // ProStateType state = proStateTypeService.get(Constants.PLAN_STATE_DELETE);
            //project.setProStateTypeByProPlanStateId(state);
            //projectService.update(project);
        }
        return  "redirect:/plan/plan-list-deal";
    }
}
