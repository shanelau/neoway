package com.jsr.findPhone.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.findPhone.bean.PhoneLog;
import com.jsr.findPhone.dao.PhoneLogDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午3:05
 * coding for fun and coding my life!
 */
@Repository("PhoneLogDao")
public class PhoneLogDaoImpl extends BaseHibernateDao<PhoneLog,Integer> implements PhoneLogDao {
    private static  final String  HQL = " from PhoneLog pl ";
    private static  final String  FIND_TOP_BY_IMEI = HQL+"where pl.phoneInfoByPhId.imeiNo=? and pl.name=? and pl.client=? order by pl.logTime desc";

    @Override
    public PhoneLog getTopByImei(String imei,String manu,boolean client) {
        return  unique(FIND_TOP_BY_IMEI,imei,manu,client);
    }
}
