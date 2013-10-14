package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.SmtTiepianInfo;
import cn.neoway.cloud.service.ConfInfoService;
import cn.neoway.cloud.service.SmtTitpianInfoService;
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
 * Time: 上午11:45
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class SmtTitpianInfoServiceImplTest {
    @Autowired
    @Qualifier("SmtTitpianInfoService")
    SmtTitpianInfoService smtTitpianInfoService;
    @Test
    public void testAdd(){
        SmtTiepianInfo sti = new SmtTiepianInfo();
        sti.setPcbName("PCB名");
        sti.setPcbaCode("pcb代码");
        sti.setPcbLiaodan("pcb_料单");
        sti.setHardwareEditon("硬件版本");
        sti.setTiepianFile("贴片文件");
        sti.setSmtDate(new Timestamp(System.currentTimeMillis()));
        smtTitpianInfoService.save(sti);
    }
}
