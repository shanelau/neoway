package com.jsr.fota.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.fota.bean.FotaBrand;
import com.jsr.fota.dao.FotaBrandDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:36
 * coding for fun and coding my life!
 */
@Repository("FotaBrandDao")
public class FotaBrandDaoImpl extends BaseHibernateDao<FotaBrand,Integer> implements FotaBrandDao {
}
