package com.jsr.feedback.controller;

import com.jsr.common.service.FileUploadService;
import com.jsr.feedback.FeedBackConstants;
import com.jsr.feedback.bean.FbAnswer;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.service.AnswerService;
import com.jsr.feedback.service.FbFeedbacksService;
import com.jsr.feedback.service.FbStatuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

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
    @Qualifier("AnswerService")
    AnswerService answerService;



    @RequestMapping(value = "/add")
    @ResponseBody
    public boolean addAnswer(@RequestParam int fbId,@RequestParam String content,HttpServletResponse response){
        //response.addHeader("Access-Control-Allow-Origin","*");  //同源请求
        try{
            answerService.saveAndModifyStatus(fbId, content);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @RequestMapping(value = "/getByfbId")
    @ResponseBody
    public List<FbAnswer> getByFbId(@RequestParam("fbId") int fbId, HttpServletResponse response){
        //response.addHeader("Access-Control-Allow-Origin","*");  //同源请求
        List<FbAnswer> list = answerService.getByFbId(fbId);
        return answerFilter(list);
    }
    public List<FbAnswer> answerFilter(List<FbAnswer> list){
        for(FbAnswer fbAnswer:list){
           Users users = fbAnswer.getUsersByUserId();
            users.setFbAnswersByUserId(null);
            users.setUsersRolesesByUserId(null);
            fbAnswer.setFbFeedbacksByFbId(null);
        }
        return list;
    }

}
