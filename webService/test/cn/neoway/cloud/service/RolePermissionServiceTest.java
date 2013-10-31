package cn.neoway.cloud.service;

import cn.neoway.cloud.bean.RolesPermissions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class RolePermissionServiceTest {
    @Autowired
    @Resource(name = "RolePermissionService")
    RolePermissionService rolePermissionService;

    @Test
    public void testFindPermissionByRoleId() throws Exception {
        List<RolesPermissions> list = rolePermissionService.findPermissionByRoleId(2);
        for (RolesPermissions rp : list) {
            System.out.println(rp.toString());
        }
    }
}
