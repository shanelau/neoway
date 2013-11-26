package com.jsr.feedback.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.feedback.bean.FbAnswer;
import com.jsr.feedback.dao.AnswerDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-25
 * Time: 下午4:10
 * coding for fun and coding my life!
 */
@Repository("AnswerDao")
public class AnswerDaoImpl extends BaseHibernateDao<FbAnswer,Integer> implements AnswerDao {
}
