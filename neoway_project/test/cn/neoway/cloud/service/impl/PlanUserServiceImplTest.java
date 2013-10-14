package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.PlanUser;
import cn.neoway.cloud.bean.PlanUserType;
import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.bean.Users;
import cn.neoway.cloud.model.SimplePlanModel;
import cn.neoway.cloud.service.PlanUserService;
import cn.neoway.cloud.service.PlanUserTypeService;
import cn.neoway.cloud.service.ProjectService;
import cn.neoway.cloud.service.UserInfoService;
import net.sf.json.JSONArray;
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
 * Date: 13-9-23
 * Time: 下午3:26
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class PlanUserServiceImplTest {
    @Autowired
    @Qualifier("PlanUserService")
    PlanUserService planUserService;
    @Autowired
    @Qualifier("ProjectService")
    ProjectService projectService;
    @Autowired
    @Qualifier("PlanUserTypeService")
    PlanUserTypeService planUserTypeService;
    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;


    @Test
    public void add(){
        PlanUser pu = new PlanUser();
        pu.setUsersByUserId(userInfoService.findUserByName("liux"));
        Project project = new Project();
        project.setModuleProId("ak123");
        pu.setProjectByProPlanId(project);
        //pu.setProjectByProPlanId(projectService.get(1));
        pu.setPlanUserTypeByPlanUserTypeId(planUserTypeService.get(1));
        planUserService.save(pu);
    }
    @Test
    public void getDealPlanList(){
        List<SimplePlanModel> list = planUserService.getDealProjectList();
        for(SimplePlanModel spm :list){
            System.out.println(spm.toString());
        }
    }
    @Test
    public void getUserListByProjectId(){
        List<PlanUser> list = planUserService.getUserListByProjectId(91);
        for(PlanUser pu :list){
            Users u = pu.getUsersByUserId();
            PlanUserType pt = pu.getPlanUserTypeByPlanUserTypeId();
            System.out.println(u.getUserName()+"\t"+u.getEmail()+"\t"+pt.getPlanUserTypeName());
        }
    }
    @Test
    public void getByDealuser(){
         PlanUser pu = planUserService.getByDealuser(150,"ak");
        System.out.print(pu.getPlanUserListId1());
    }

}
