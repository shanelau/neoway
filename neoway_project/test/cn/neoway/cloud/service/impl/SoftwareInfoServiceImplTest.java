package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.cloud.bean.SoftwareType;
import cn.neoway.cloud.service.SoftwareInfoService;
import cn.neoway.cloud.service.SoftwareTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class SoftwareInfoServiceImplTest {
    @Autowired
    @Qualifier("SoftwareInfoService")
    SoftwareInfoService softwareInfoService;
    @Autowired
    @Qualifier("SoftwareTypeService")
    SoftwareTypeService softwareTypeService;

    @Test
    public void addSoftware(){
        for(int i=1;i<9;i++){
             SoftwareInfo softwareInfo = new SoftwareInfo();
            softwareInfo.setSoftName("软件"+i);
            softwareInfo.setSoftwarePath("软件路径"+i);
            softwareInfo.setVariasoftEdition("版本号"+i);
            softwareInfo.setSoftRemark("备注"+i);
            softwareInfo.setDate(new Timestamp(System.currentTimeMillis()));
            SoftwareType softwareInfoType = softwareTypeService.get(i);
            softwareInfo.setSoftwareTypeBySoftTypeId(softwareInfoType);
            softwareInfoService.save(softwareInfo);
        }
    }
    @Test
    public void getNullFileBySoftType(){
        List<SoftwareInfo> softwareInfo = softwareInfoService.getNullFileByTypeId();
        for(SoftwareInfo si :softwareInfo){
            System.out.println(si.getProSoftwareId()+si.getSoftName());
        }
    }
}
