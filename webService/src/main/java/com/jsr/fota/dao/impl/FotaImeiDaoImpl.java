package com.jsr.fota.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.fota.bean.FotaImei;
import com.jsr.fota.dao.FotaImeiDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-25
 * Time: 下午4:40
 * coding for fun and coding my life!
 */
@Repository("FotaImeiDao")
public class FotaImeiDaoImpl extends BaseHibernateDao<FotaImei,String> implements FotaImeiDao {
}
