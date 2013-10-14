package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.ConfInfo;
import cn.neoway.cloud.service.ConfInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ConfInfoServiceImplTest {
    @Autowired
    @Qualifier("ConfInfoService")
    ConfInfoService confInfoService;
    @Test
    public void testAdd(){
        ConfInfo confInfo = new ConfInfo();
        confInfo.setConfFileName("配置文件1");
        confInfo.setConfPath("c://dsd/dsa.txt");
        confInfo.setRemark("这是一个配置文件");
        confInfo.setUploadDate(new Timestamp(System.currentTimeMillis()));
        confInfoService.save(confInfo);
    }

}
