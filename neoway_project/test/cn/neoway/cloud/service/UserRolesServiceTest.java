package cn.neoway.cloud.service;

import cn.neoway.cloud.bean.UserRoles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class UserRolesServiceTest {
    @Autowired
    @Qualifier("UserRolesService")
    UserRolesService userRolesService;
    @Test
    public void testFindByUserId() throws Exception {
        List<UserRoles> list = userRolesService.findByUserId(1);
        for(UserRoles ur:list){
            System.out.println(ur.toString());
        }
    }
}
