package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.*;
import cn.neoway.cloud.service.*;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ProjectServiceImplTest {
    @Autowired
    @Qualifier("ProjectService")
    ProjectService projectService;
    @Autowired
    @Qualifier("ConfInfoService")
    ConfInfoService confInfoService;

    @Autowired
    @Qualifier("SmtTitpianInfoService")
    SmtTitpianInfoService smtTitpianInfoService;
    @Autowired
    @Qualifier("PlanUserService")
    PlanUserService planUserService;

    @Test
    public void testFindByModuleProId() throws Exception {
        Project project = projectService.findByModuleProId("风继续吹");
        System.out.print(project.getModuleProId()+"\t"+project.getSendEmail());
    }
    @Test
    public void testAdd(){
        Project p = new Project();
        p.setModuleProId("YYF_1020");
        p.setProSource("市场部");
        p.setProceManu("华为");
        p.setMkType("AK47");
        p.setProceCount(10000);
        p.setAccomplishDate(new Timestamp(System.currentTimeMillis()));
        p.setProCreateDate(new Timestamp(System.currentTimeMillis()));
        p.setProPassDate(new Timestamp(System.currentTimeMillis()));
        p.setPackResource("发货地");
        p.setPackProCode("PackProCod");
        p.setPackBaudRate("PackBaudRate");
        p.setPackBiaotieNo("BiaotieNo");
        p.setPackCaihe("PackCaihe");
        p.setPackDakat("PackDakat");
        p.setPackImeiEnd("ImeiEnd");
        p.setPackImeiStart("ImeiStart");
        p.setPackIsBiaotie("PackIsBiaotie");
        p.setPackIsCheck(false);
        p.setPackBaudRate("BaudRate");
        p.setPackPeiliao("Peiliao");
        p.setPackProName("PackProName");
        p.setPackSoftwareNo("SoftwareNo");
        p.setPackTangdaiNo("packTangdaiNo");
        p.setPackUpdateRate(false);
        p.setProSnEnd("SN_end");
        p.setProSnStart("SN_start");
        p.setSendEmail("抄送给");


        projectService.save(p);
    }
    @Test
    public void testUpdate(){
        Project project = projectService.findByModuleProId("YYF_1021");
        project.setSendEmail("中共中央");
        projectService.update(project);
    }
    @Test
    public void testDelete(){
        Project project = projectService.findByModuleProId("YYF_1020");
        projectService.deleteObject(project);
    }
    public void testAddPlanUser(){

    }
    @Test
    public void testAddConfig(){
        Project project = projectService.findByModuleProId("YYF_1021");
        ConfInfo confInfo = confInfoService.get(1);
        project.setConfInfoByConfFileId(confInfo);
        projectService.update(project);
    }
    @Test
    public void testAddSMT(){
        Project project = projectService.findByModuleProId("YYF_1021");
        SmtTiepianInfo smtTiepianInfo = smtTitpianInfoService.get(1);
        if(project!=null){
            project.setSmtTiepianInfoBySmtId(smtTiepianInfo);
            projectService.update(project);
        }
    }
    @Test
    public void findSoftInfo(){

        Project project = projectService.get(1);
        Collection<ProSoftList> list = project.getProSoftListsByProjectId();
        for(ProSoftList psl : list){
            System.out.println(psl.getProjectByProPlanId().getPackProName()+"\t"+psl.getSoftwareInfoByProSoftwareId().getSoftName()+"\t"+psl.getSoftwareInfoByProSoftwareId().getSoftwareTypeBySoftTypeId().getSoftTypeName());
        }
    }
    @Test
    public void getById(){
        Project project = projectService.findByModuleProId("a14");
        project.setProStateTypeByProPlanStateId(null);
        project.setPlanUsersByProPlanId(null);
        List planUserList = planUserService.getUserListByProjectId(project.getProPlanId());
        project.setPlanUsersByProPlanId(planUserList);
        System.out.println(JSONObject.fromObject(project).toString());
    }
}
