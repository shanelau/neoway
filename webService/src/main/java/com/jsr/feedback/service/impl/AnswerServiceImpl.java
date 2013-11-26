package com.jsr.feedback.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.FbAnswer;
import com.jsr.feedback.dao.AnswerDao;
import com.jsr.feedback.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-25
 * Time: 下午4:11
 * coding for fun and coding my life!
 */
@Service("AnswerService")
public class AnswerServiceImpl extends BaseService<FbAnswer,Integer> implements AnswerService {
    private AnswerDao answerDao;
    @Autowired
    @Qualifier("AnswerDao")
    @Override
    public void setBaseDao(IBaseDao<FbAnswer, Integer> baseDao) {
        this.baseDao = baseDao;
        this.answerDao = (AnswerDao) baseDao;
    }
}
