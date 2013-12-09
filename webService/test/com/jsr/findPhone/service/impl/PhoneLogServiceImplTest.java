package com.jsr.findPhone.service.impl;

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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-7
 * Time: 下午2:02
 * coding for fun and coding my life!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class PhoneLogServiceImplTest {
    @Autowired
    @Qualifier("PhoneLogService")
    PhoneLogService phoneLogService;

    @Autowired
    @Qualifier("PhoneInfoService")
    PhoneInfoService phoneInfoService;

    @Test
    public void testSave() throws Exception {
        PhoneInfo phone = phoneInfoService.get(1);
        if(phone==null)
            throw new RuntimeException("device is not found");
        String x =  "116.404";
        String y = "39.915";
        PhoneLog phoneLog = new PhoneLog();
        phoneLog.setPointX(x);
        phoneLog.setPointY(y);
        phoneLog.setLogTime(new Timestamp(System.currentTimeMillis()));
        phoneLog.setClient(true);
        phoneLog.setName("location");
        phoneLog.setPhoneInfoByPhId(phone);
        PhoneLog phoneLog2 = phoneLogService.save(phoneLog);
        Assert.assertNotNull(phoneLog2);;
    }

    @Test
    public void testUpdate() throws Exception {

    }
    @Test
    public void getTop(){
        PhoneLog phoneLog = phoneLogService.getTopByImei("A1000012345678", "location", true);
        System.out.println(phoneLog.getLogId());
    }
}
