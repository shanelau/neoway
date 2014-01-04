package com.jsr.fota.service.impl;

import com.jsr.fota.bean.FotaBrand;
import com.jsr.fota.bean.FotaVersion;
import com.jsr.fota.service.FotaBrandService;
import com.jsr.fota.service.FotaVersionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午4:45
 * coding for fun and coding my life!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class FotaVersionServiceImplTest {
    @Autowired
    @Qualifier("FotaVersionService")
    FotaVersionService fotaVersionService;

    @Autowired
    @Qualifier("FotaBrandService")
    FotaBrandService fotaBrandService;
    @Test
    public void testSave() throws Exception {
        FotaBrand fotaBrand = fotaBrandService.get(2);
        FotaVersion fotaVersion = new FotaVersion();
        fotaVersion.setFotaBrandByBrandId(fotaBrand);
        fotaVersion.setVersionDate(new Timestamp(System.currentTimeMillis()));
        fotaVersion.setVersionName("ROM_D10C_V1");
        fotaVersion.setVersionDesc("2. 修正12群组超过七个，");
        fotaVersionService.save(fotaVersion);
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
    @Test
    public void testGetCanUpdateList(){
        List<FotaVersion> list = fotaVersionService.getCanUpdateList(13);
        System.out.println(list.size());
    }
}
