package com.jsr.feedback.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.feedback.bean.FbType;
import com.jsr.feedback.dao.FbTypeDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-20
 * Time: 上午8:44
 * coding for fun and coding my life!
 */
@Repository("FbTypeDao")
public class FbTypeDaoImpl extends BaseHibernateDao<FbType, Integer> implements FbTypeDao {
    public static String HQL_LIST_ALL = " from FbType type order by type.typeId asc";
    @Override
    public List<FbType> listAll() {
        return list(HQL_LIST_ALL,-1,Integer.MAX_VALUE);
    }
}
