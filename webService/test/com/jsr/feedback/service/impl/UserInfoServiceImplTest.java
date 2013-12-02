package com.jsr.feedback.service.impl;

import com.jsr.feedback.bean.Users;
import com.jsr.feedback.service.UserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-28
 * Time: 上午11:00
 * coding for fun and coding my life!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class UserInfoServiceImplTest {
    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;

    @Test
    public void testFindUserByName() throws Exception {
        Assert.assertNotNull(userInfoService.findUserByName("ak124"));
    }

    @Test
    public void testListByKeyword() throws Exception {

    }

    @Test
    public void testQuery() throws Exception {

    }
    @Test
    public void update(){
        Users users = userInfoService.findUserByName("ak124");
        users.setValidataCode("aaa");
        users.update();
    }
    @Test
    public void testForgetPassword(){
        try {
            userInfoService.updateForgetPassword("ak123","");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
