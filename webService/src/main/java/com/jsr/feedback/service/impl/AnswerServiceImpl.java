package com.jsr.feedback.service.impl;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.FeedBackConstants;
import com.jsr.feedback.bean.FbAnswer;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.dao.AnswerDao;
import com.jsr.feedback.service.AnswerService;
import com.jsr.feedback.service.FbFeedbacksService;
import com.jsr.feedback.service.FbStatuService;
import com.jsr.pushclient.PushManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-25
 * Time: 下午4:11
 * coding for fun and coding my life!
 */
@Service("AnswerService")
public class AnswerServiceImpl extends BaseService<FbAnswer,Integer> implements AnswerService {
    Logger logger = Logger.getLogger(AnswerServiceImpl.class.getName());
    @Autowired
    @Qualifier("FbStatuService")
    FbStatuService fbStatuService;
    @Autowired
    @Qualifier("FbFeedbacksService")
    FbFeedbacksService fbFeedbacksService;

    private AnswerDao answerDao;



    @Autowired
    @Qualifier("AnswerDao")
    @Override
    public void setBaseDao(IBaseDao<FbAnswer, Integer> baseDao) {
        this.baseDao = baseDao;
        this.answerDao = (AnswerDao) baseDao;
    }

    @Override
    public void saveAndModifyStatus(int fbId, String content) throws Exception {
        //推送到终端
        pushToPhone(saveAnswer(fbId,content),content);
    }

    @Override
    public List<FbAnswer> getByFbId(int fbId) {
        return answerDao.getByFbId(fbId);
    }

    /**
     *
     * @param fbId        feedback编号
     * @param content     回复的内容
     * @return           feedback对象
     * @throws Exception
     */
    public FbFeedbacks saveAnswer(int fbId, String content) throws Exception {
        FbFeedbacks fbFeedbacks = fbFeedbacksService.get(fbId);
        if(fbFeedbacks == null)
            throw new Exception("fbId not exist!");
        FbAnswer fbAnswer = new FbAnswer();
        fbAnswer.setContent(content);
        fbFeedbacks.setFbStatuByStatusId(fbStatuService.get(FeedBackConstants.FEEDBACK_STATUS_REPLYED));
        fbAnswer.setFbFeedbacksByFbId(fbFeedbacks);
        fbAnswer.setReplyTime(new Timestamp(System.currentTimeMillis()));

        Subject currentUser = SecurityUtils.getSubject();
        Users users = (Users) currentUser.getSession().getAttribute("currUser");
        fbAnswer.setUsersByUserId(users);
        saveOrUpdate(fbAnswer);
        return fbFeedbacks;
    }

    /**
     *
     * @param fbFeedbacks     反馈对象
     * @param message         回复的信息
     */
    public void pushToPhone(FbFeedbacks fbFeedbacks,String message){
        String imei = fbFeedbacks.getPhImei();
        if(FeedBackConstants.CAN_PUSH_TO_CLENT && imei!=null && !imei.equals("")){
            try {
                PushManager.getInstance().sendMessage(FeedBackConstants.PUSH_FROM,imei,FeedBackConstants.getPushMap(message));
                logger.info("推送到"+imei+":"+FeedBackConstants.getPushMap(message));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
    }
    /**
     *
     * @param imeis     手机的imei
     * @param message   回复的信息
     */
    public void pushToPhone( List<String > imeis,String message){
        if(FeedBackConstants.CAN_PUSH_TO_CLENT && imeis!=null && imeis.size()>0){
            try {
                PushManager.getInstance().sendMessage(FeedBackConstants.PUSH_FROM,imeis,FeedBackConstants.getPushMap(message));
                logger.info("推送到"+imeis.toArray()+":"+FeedBackConstants.getPushMap(message));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void saveReplyAll(int[] addr, String message) {
        List imeis = new ArrayList();
          for(int fbId:addr){
              try {
                  FbFeedbacks fb = saveAnswer(fbId, message);
                  String phImei = fb.getPhImei();
                  if(phImei !=null && !phImei.equals("")){
                      imeis.add(phImei);
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
        pushToPhone(imeis,message);//推送到手机
    }


}
