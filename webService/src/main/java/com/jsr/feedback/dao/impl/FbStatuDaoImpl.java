package com.jsr.feedback.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.feedback.bean.FbStatu;
import com.jsr.feedback.dao.FbStatuDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-20
 * Time: 上午8:42
 * coding for fun and coding my life!
 */
@Repository("FbStatuDao")
public class FbStatuDaoImpl extends BaseHibernateDao<FbStatu, Integer> implements FbStatuDao {
}
