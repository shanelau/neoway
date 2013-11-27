package com.jsr.feedback.service.impl;

import com.jsr.feedback.bean.FbAnswer;
import com.jsr.feedback.service.AnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-26
 * Time: 下午7:00
 * coding for fun and coding my life!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class AnswerServiceImplTest {

    @Autowired
    @Qualifier("AnswerService")
    AnswerService answerService;

    @Test
    public void testSaveAndModifyStatus() throws Exception {

    }

    @Test
    public void testGetByFbId() throws Exception {
        List<FbAnswer> list = answerService.getByFbId(54);
        System.out.println(list.size());
    }
}
