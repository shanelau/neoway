package com.jsr.fota.service.impl;

import com.jsr.fota.FotaConstants;
import com.jsr.fota.bean.FotaFile;
import com.jsr.fota.service.FotaFileService;
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
 * Date: 13-12-24
 * Time: 下午1:48
 * coding for fun and coding my life!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class FotaFileServiceImplTest {
    @Autowired
    @Qualifier("FotaFileService")
    FotaFileService fotaFileService;

    @Autowired
    @Qualifier("FotaVersionService")
    FotaVersionService fotaVersionService;
    @Test
    public void testSave() throws Exception {

        FotaFile fotaFile = new FotaFile();
        fotaFile.setFileName(" ROM_D10C_V14-ROM_D10C_V2.zip");
        fotaFile.setBcsObject("ROM_D10C_V14-ROM_D10C_V2");
        fotaFile.setFileDate(new Timestamp(System.currentTimeMillis()));
        fotaFile.setSize("8M");
        fotaFile.setStatus(true);
        fotaFile.setUpdateTo(5);
        fotaFile.setFotaVersionByVersionId(fotaVersionService.get(1));
        fotaFile.setUrl("url");
        fotaFileService.save(fotaFile);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        FotaFile fotaFile = fotaFileService.get(13);
        String msg = FotaConstants.getPushMap(fotaFile, fotaVersionService.get(fotaFile.getUpdateTo()).getVersionName());
        System.out.println(msg);
    }
    @Test
    public void listUpdateTo(){
        List<FotaFile> list = fotaFileService.listUpdateTo(5);
        System.out.println(list.size());
    }
}
