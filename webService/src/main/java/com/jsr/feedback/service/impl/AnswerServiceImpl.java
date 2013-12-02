package com.jsr.feedback.service.impl;

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

import java.sql.Timestamp;
import java.util.List;

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
        //Users u = userService.get(users.getUserId());
        fbAnswer.setUsersByUserId(users);
        saveOrUpdate(fbAnswer);
        //推送到终端
        String imei = fbFeedbacks.getPhImei();
        if(FeedBackConstants.CAN_PUSH_TO_CLENT && imei!=null && !imei.equals("")){
            PushManager.getInstance().sendMessage(FeedBackConstants.PUSH_FROM,fbFeedbacks.getPhImei(),content);
            logger.info("推送到"+imei+":"+content);
        }
    }

    @Override
    public List<FbAnswer> getByFbId(int fbId) {
        return answerDao.getByFbId(fbId);
    }
}
