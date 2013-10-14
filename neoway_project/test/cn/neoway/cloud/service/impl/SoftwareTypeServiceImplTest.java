package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.cloud.bean.SoftwareType;
import cn.neoway.cloud.service.SoftwareTypeService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-25
 * Time: 下午1:59
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class SoftwareTypeServiceImplTest {
    @Autowired
    @Qualifier("SoftwareTypeService")
    SoftwareTypeService softwareTypeService;

    @Test
    public void getSoftList(){
        SoftwareType softwareType = softwareTypeService.get(1);
        Collection<SoftwareInfo> set = softwareType.getSoftwareInfosBySoftTypeId();
        List list = new ArrayList<SoftwareInfo>();
        for(SoftwareInfo softwareInfo :set){
            softwareInfo.setSoftwareTypeBySoftTypeId(null);
            softwareInfo.setProSoftListsByProSoftwareId(null);
            list.add(softwareInfo);
        }
        System.out.print(JSONArray.fromObject(list).toString());

    }
}
