package com.jsr.feedback.controller;

import com.jsr.feedback.FeedBackConstants;
import com.jsr.feedback.bean.FbAnswer;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
            users.setPhoneInfoByUserId(null);
            fbAnswer.setFbFeedbacksByFbId(null);
        }
        return list;
    }
    @RequestMapping(value = "/multiReply",method = RequestMethod.POST)
    @ResponseBody
    public Map mutipleReply(@RequestParam(value = "address" ,required = true) String address,@RequestParam(value = "message" ,required = true) String message){
        int[] fbIds = null;
        try{
            address = address.trim();
            if(address.contains(FeedBackConstants.SPLIT)){      //逗号隔开
                String[] addr = address.split(FeedBackConstants.SPLIT);
                fbIds = new int[addr.length];
                for(int i=0;i<addr.length;i++){
                    fbIds[i]=Integer.parseInt(addr[i].trim());      //获取到int类型的fbId
                }
            } else if(address.toLowerCase().contains(FeedBackConstants.TO)){      //输入的为范围
                String[] addr = address.split(FeedBackConstants.TO);
                int start = Integer.parseInt(addr[0].trim());
                int end = Integer.parseInt(addr[1].trim());
                int min = start<end?start:end;
                int max = start>end?start:end;
                fbIds = new int[max-min+1];
                for(int j=0,i = min;i<=max;i++,j++){
                    fbIds[j]=i;
                }
            }else{
                fbIds = new int[]{Integer.parseInt(address)};
            }

            answerService.saveReplyAll(fbIds, message);
            return FeedBackConstants.getMessage(true,"批量推送成功");
        }catch (Exception e){
            e.printStackTrace();
            return FeedBackConstants.getMessage(false,"输入有误,系统报错啦");
        }
    }


}
