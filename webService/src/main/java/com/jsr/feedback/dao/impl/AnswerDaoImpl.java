package com.jsr.feedback.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.feedback.bean.FbAnswer;
import com.jsr.feedback.dao.AnswerDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-25
 * Time: 下午4:10
 * coding for fun and coding my life!
 */
@Repository("AnswerDao")
public class AnswerDaoImpl extends BaseHibernateDao<FbAnswer,Integer> implements AnswerDao {
    public static String HQL_GET_ANSWER_BY_FBID= " from FbAnswer a where a.fbFeedbacksByFbId.fbId = ?";
    @Override
    public List<FbAnswer> getByFbId(int fbId) {
        return list(HQL_GET_ANSWER_BY_FBID,-1,Integer.MAX_VALUE,fbId);
    }
}
