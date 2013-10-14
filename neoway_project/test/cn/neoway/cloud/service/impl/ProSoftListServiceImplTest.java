package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.ProSoftList;
import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.cloud.bean.SoftwareType;
import cn.neoway.cloud.service.ProSoftListService;
import cn.neoway.cloud.service.ProjectService;
import cn.neoway.cloud.service.SoftwareInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ProSoftListServiceImplTest {
    @Autowired
    @Qualifier("ProSoftListService")
    ProSoftListService proSoftListService;

    @Autowired
    @Qualifier("ProjectService")
    ProjectService projectService;

    @Autowired
    @Qualifier("SoftwareInfoService")
    SoftwareInfoService softwareInfoService;

    @Test
    public void add(){
       Project project = projectService.get(1);
        for(int i=1;i<9;i++){
           SoftwareInfo softwareInfo = softwareInfoService.get(i);
            if(project!=null && softwareInfo!=null){
               ProSoftList proSoftList = new ProSoftList();
               proSoftList.setProjectByProPlanId(project);
               proSoftList.setSoftwareInfoByProSoftwareId(softwareInfo);
               proSoftListService.save(proSoftList);
            }
        }
    }
    public void  print(){
        //sti = softwareInfoService
    }
    @Test
    public void findByProPlanId(){
        List<ProSoftList> list = proSoftListService.findByProPlanId(1);
        for(ProSoftList psl : list){
            System.out.println(psl.getProjectByProPlanId().getPackProName()+"\t"+psl.getSoftwareInfoByProSoftwareId().getSoftName()+"\t"+psl.getSoftwareInfoByProSoftwareId().getSoftwareTypeBySoftTypeId().getSoftTypeName());
        }
    }
    @Test
    public void addSoftType(){
        String typeName = "更新工具";
        int proPlanId = 111;
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

        proSoftListService.save(proSoftList);
    }
}
