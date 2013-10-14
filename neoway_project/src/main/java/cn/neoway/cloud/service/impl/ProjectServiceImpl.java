package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.*;
import cn.neoway.cloud.dao.ProjectDao;
import cn.neoway.cloud.model.ProjectModel;
import cn.neoway.cloud.model.SimplePlanModel;
import cn.neoway.cloud.service.*;
import cn.neoway.common.Constants;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
@Service("ProjectService")
public class ProjectServiceImpl extends BaseService<Project,Integer> implements ProjectService {

    ProjectDao projectDao;
    @Autowired
    @Qualifier("PlanUserService")
    PlanUserService planUserService;

    Project project ;
    @Autowired
    @Qualifier("PlanUserTypeService")
    PlanUserTypeService planUserTypeService;
    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;
    @Autowired
    @Qualifier("SoftwareTypeService")
    SoftwareTypeService softwareTypeService;
    @Autowired
    @Qualifier("ProStatetTypeService")
    ProStatetTypeService proStateTypeService;
    @Autowired
    @Qualifier("SoftwareInfoService")
    SoftwareInfoService softwareInfoService;


    @Autowired
    @Qualifier("ProjectDao")
    @Override
    public void setBaseDao(IBaseDao<Project, Integer> baseDao) {
        this.baseDao = baseDao;
        projectDao =  (ProjectDao)baseDao;
    }

    @Override
    public Project findByModuleProId(String id) {
        return projectDao.findByModuleProId(id);
    }

    @Override
    public ConfInfo findConfigByProjectId(int id) {
        return projectDao.findConfigByProjectId(id);
    }

    @Override
    public void addConfigInfo(ConfInfo confInfo, String moduleId) {
        Project project = findByModuleProId(moduleId);
        if(project!=null){
            project.setConfInfoByConfFileId(confInfo);
        }
    }
    @Override
    public void updateProject(ProjectModel projectModel,int stateTypeId) {
        Users[] ayy = getUser(projectModel);
        Project project1 = getProject(projectModel);
        ProStateType proStateTyp = getProjectState(stateTypeId);
        project1.setProStateTypeByProPlanStateId(proStateTyp);
        List planUserList = new ArrayList();
            for(int i=1;i<=ayy.length;i++){
                PlanUser pu = planUserService.getPlanUser(project1.getModuleProId(),i);
                if( i == stateTypeId){
                    pu.setDealAdvice("我已经填写完毕,等待提交");
                    String user = projectModel.getProCreateUser();
                    if(user!=null && !user.equals("")){
                        user = user.split(",")[0];
                    }
                    pu.setDealUser(user);       //这次处理的人
                    pu.setPass(false);
                    pu.setDealTime(new Timestamp(System.currentTimeMillis()));
                }
                pu.setPlanUserTypeByPlanUserTypeId(planUserTypeService.get(i));
                pu.setUsersByUserId(ayy[i - 1]);
                planUserList.add(pu);
            }
            project1.setPlanUsersByProPlanId(planUserList);
            saveOrUpdate(project1);
    }

    @Override
    public Users[] getUser(ProjectModel projectModel) {
        Users[] ayy = new Users[5];
        ayy[0] = getUser(projectModel.getProCreateUser());          //计划人
        ayy[1]=  getUser(projectModel.getConfUser());               //配置文件
        ayy[2] = getUser(projectModel.getProTechUser());         //生产技术
        ayy[3] = getUser(projectModel.getSoftManUser());         //软件经理
        ayy[4] = getUser(projectModel.getProManUser());           //项目经理
        return ayy;
    }

    public Users getUser(String username){
        if(username !=null && !(username.trim()).equals("")){
            return userInfoService.findUserByName(username);
        }
        return null;
    }
    public ProStateType getProjectState( int stateTypeId){
        ProStateType proStateType = proStateTypeService.get(stateTypeId);    //设置状态
        return proStateType;
    }
    public Project getProject(ProjectModel projectModel){
        Integer proPlanId = projectModel.getProPlanId();
        if(proPlanId == null){
            project = new Project();
        }else {
            project = get(proPlanId);
        }
        project.setModuleProId(projectModel.getModuleProId());
        project.setProSource(projectModel.getProSource());
        project.setProceManu(projectModel.getProceManu());
        project.setREVVversion(projectModel.getRevVersion());
        project.setMkType(projectModel.getMkType());
        project.setProceCount(projectModel.getProceCount());
        project.setAccomplishDate(projectModel.getAccomplishDate());
        project.setPackProCode(projectModel.getPackProCode());
        project.setPackProName(projectModel.getPackProName());
      //  project.setPackResource(projectModel.getPackResource());
        project.setPackSoftwareNo(projectModel.getPackSoftwareNo());
       // project.setPackPeiliao(projectModel.getPackPeiliao());
       // project.setPackCaihe(projectModel.getPackCaihe());
       // project.setPackDakat(projectModel.getPackDakat());
        project.setPackIsBiaotie(projectModel.getPackIsBiaotie());
        project.setPackUpdateRate(projectModel.getPackUpdateRate());//是否修改波特率
        project.setPackBaudRate(projectModel.getPackBaudRate());
        project.setPackIsCheck(projectModel.getPackIsCheck());

        project.setPackImeiStart(projectModel.getPackImeiStart());
        project.setPackImeiEnd(projectModel.getPackImeiEnd());
        project.setPackBiaotieNo(projectModel.getPackBiaotieNo());
        project.setPackTangdaiNo(projectModel.getPackTangdaiNo());
        project.setProSnEnd(projectModel.getProSnEnd());
        project.setProSnStart(projectModel.getProSnStart());
        project.setSendEmail(projectModel.getSendEmail());

        project.setProCreateDate(new Timestamp(System.currentTimeMillis()));
        return project;
    }



}
