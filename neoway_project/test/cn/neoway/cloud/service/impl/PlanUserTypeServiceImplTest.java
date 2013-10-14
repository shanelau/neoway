package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.PlanUserType;
import cn.neoway.cloud.service.PlanUserTypeService;
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
 * Time: 下午2:59
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class PlanUserTypeServiceImplTest {
    @Autowired
    @Qualifier("PlanUserTypeService")
    PlanUserTypeService planUserTypeService;
    @Test
    public void testList(){
        List<PlanUserType> list = planUserTypeService.listAll();
        for(PlanUserType p :list){
               System.out.print(p.toString());
        }
    }
}
