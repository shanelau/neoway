package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.Users;
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
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class UserInfoServiceImplTest {
    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;
    @Test
    public void testFindByName(){
        Users u = userInfoService.findUserByName("liux");
        System.out.print(u.getUserName()+"\t"+u.getEmail());
    }
    @Test
    public void getAll(){
        List<Users> userList = userInfoService.listAll();
        for(Users users :userList){
            users.setUserRolesesByUserId(null);
            users.setPlanUsersByUserId(null);
            users.setManuLogsByUserId(null);

        }
        System.out.print(JSONArray.fromObject(userList));
    }
    @Test
    public void listByKeyword(){
        List<Users> userList = userInfoService.listByKeyword("l");
        for(Users users :userList){
            users.setUserRolesesByUserId(null);
            users.setPlanUsersByUserId(null);
            users.setManuLogsByUserId(null);

        }
        System.out.print(JSONArray.fromObject(userList));
    }
}
