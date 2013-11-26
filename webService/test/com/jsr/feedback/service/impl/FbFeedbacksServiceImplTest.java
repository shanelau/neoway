package com.jsr.feedback.service.impl;

import com.jsr.common.pagination.Page;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.model.FBQueryModel;
import com.jsr.feedback.service.FbFeedbacksService;
import com.jsr.feedback.service.FbStatuService;
import com.jsr.feedback.service.FbTypeService;
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
 * Date: 13-11-19
 * Time: 下午9:58
 * coding for fun and coding my life!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class FbFeedbacksServiceImplTest {
    @Autowired
    @Qualifier("FbFeedbacksService")
    FbFeedbacksService fbFeedbacksService;
    @Autowired
    FbTypeService fbTypeService;
    @Autowired
    FbStatuService fbStatuService;

    @Test
    public void testSave() throws Exception {
        FbFeedbacks mFbFeedback = new FbFeedbacks();
        mFbFeedback.setContent("什么飞机");
        mFbFeedback.setFbDate(new Timestamp(System.currentTimeMillis()));
        mFbFeedback.setImgPath("C:/");
        mFbFeedback.setVersion("D10");
        mFbFeedback.setPhImei("IMEI");
        mFbFeedback.setSubject("主题啊");
        mFbFeedback.setFbStatuByStatusId(fbStatuService.get(1));
        mFbFeedback.setFbTypeByTypeId(fbTypeService.get(1));

        fbFeedbacksService.save(mFbFeedback);
    }

    public void testUpdate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        FbFeedbacks fbFeedbacks = fbFeedbacksService.get(1);
        System.out.print(fbFeedbacks.getSubject() + "\t" + fbFeedbacks.getContent());
    }

    public void testListAll() throws Exception {
        fbFeedbacksService.listAll();
    }
    @Test
    public void testListByStatuAndType(){
        Page<FbFeedbacks> page = fbFeedbacksService.list(1, 2, new FBQueryModel("", "", "", "desc"));
        System.out.println(page.getContext().getPageCount());
        for(int i=0;i<page.getItems().size();i++){
            FbFeedbacks fb = page.getItems().get(i);
            System.out.println(fb.getFbId()+"\t"+fb.getContent());
        }

    }
    @Test
    public void testlistAll(){
        Page<FbFeedbacks> page = fbFeedbacksService.listAll(1, 2,"","desc");
        System.out.println(page.getContext().getPageCount());
        for(int i=0;i<page.getItems().size();i++){
            FbFeedbacks fb = page.getItems().get(i);
            System.out.println(fb.getFbId()+"\t"+fb.getContent());
        }
    }
}
