package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.ManuInfo;
import cn.neoway.cloud.service.ManuInfoService;
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
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ManuInfoServiceImplTest {
    @Autowired
    @Qualifier("ManuInfoService")
    ManuInfoService manuInfoService;


    @Test
    public void add(){
        ManuInfo manuInfo = new ManuInfo();
        manuInfo.setBackCheck(false); //是否复检
        manuInfo.setManuInfoDate(new Timestamp(System.currentTimeMillis()));
        manuInfo.setManuNotice("注意事项");
        manuInfo.setManuState("生产技术状态");
        manuInfo.setReback(false);          //是否返工生产
        manuInfo.setRebackInfo("返工原因");  //
        manuInfo.setUpdateInfo("变更信息");         //变更信息
        manuInfo.setManuProcedure("1,2,3,4");
        manuInfoService.save(manuInfo);
    }

}
