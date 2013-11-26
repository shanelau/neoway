package com.jsr.feedback.controller;

import com.jsr.common.service.FileUploadService;
import com.jsr.feedback.bean.FbAnswer;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.service.AnswerService;
import com.jsr.feedback.service.FbFeedbacksService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-25
 * Time: 下午4:13
 * coding for fun and coding my life!
 */
@Controller
@RequestMapping("/feedback/answer")
public class AnswerController {
    @Autowired
    @Qualifier("FbFeedbacksService")
    FbFeedbacksService fbFeedbacksService;

    @Autowired
    @Qualifier("AnswerService")
    AnswerService answerService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public boolean addAnswer(@RequestParam int fbId,@RequestParam String content,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");  //同源请求
        FbFeedbacks fbFeedbacks = fbFeedbacksService.get(fbId);
        if(fbFeedbacks == null)
            return false;
        FbAnswer fbAnswer = new FbAnswer();
        fbAnswer.setContent(content);
        fbAnswer.setFbFeedbacksByFbId(fbFeedbacks);
        fbAnswer.setReplyTime(new Timestamp(System.currentTimeMillis()));
        try{
            answerService.saveOrUpdate(fbAnswer);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
