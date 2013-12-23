package com.jsr.fota.service.impl;

import com.jsr.fota.bean.FotaBrand;
import com.jsr.fota.service.FotaBrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:52
 * coding for fun and coding my life!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class FotaBrandServiceImplTest {
    @Autowired
    @Qualifier("FotaBrandService")
    FotaBrandService fotaBrandService;
    @Test
    public void testSave() throws Exception {
        FotaBrand fotaBrand = new FotaBrand();
        fotaBrand.setBrandName("innos");
        fotaBrand.setLanguage("CN");
        fotaBrand.setProduct("D10F");
        fotaBrand.setOem("innos");
        fotaBrandService.save(fotaBrand);

    }

    @Test
    public void testSaveOrUpdate() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }
}
