package com.jsr.findPhone.service.impl;

import com.jsr.feedback.bean.Users;
import com.jsr.feedback.service.UserInfoService;
import com.jsr.findPhone.bean.PhoneInfo;
import com.jsr.findPhone.bean.PhoneLog;
import com.jsr.findPhone.service.PhoneInfoService;
import com.jsr.findPhone.service.PhoneLogService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午3:13
 * coding for fun and coding my life!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class PhoneInfoServiceImplTest extends AbstractJUnit4SpringContextTests{
    @Autowired
    @Qualifier("PhoneInfoService")
    PhoneInfoService phoneInfoService;


    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;

    String username = "admin";
    String imei = "ABCD";

    @Test
    public void testSave() throws Exception {
        PhoneInfo phoneInfo = new PhoneInfo();
        phoneInfo.setUsersByUserId(userInfoService.findUserByName(username));
        phoneInfo.setImeiNo(imei);
        phoneInfo.setBindTime(new Timestamp(System.currentTimeMillis()));
        PhoneInfo phoneInfo2 = phoneInfoService.save(phoneInfo);
        Assert.assertNotNull(phoneInfo2);;
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
            //get by user id
        Users user = userInfoService.findUserByName(username);
        Collection<PhoneInfo> list = user.getPhoneInfoByUserId();
        for(PhoneInfo phoneInfo:list){
            print(phoneInfo);
        }
    }
    @Test
    public void testGetByIMEI(){
        PhoneInfo phoneInfo= phoneInfoService.getByImei(imei);
        Assert.assertEquals(imei,phoneInfo.getImeiNo());
    }

    @Test
    public void testCountAll() throws Exception {

    }
    public void print(PhoneInfo phoneInfo){
        System.out.println(phoneInfo.getPhId()+"\t"+phoneInfo.getImeiNo()+"\t");
    }
    @Test
    public void listByUserId(){
        List<PhoneInfo> list = phoneInfoService.getByUsername("test1");
        Assert.assertEquals(list.size(),2);
    }
}
