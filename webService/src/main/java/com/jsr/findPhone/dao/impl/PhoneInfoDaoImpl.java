package com.jsr.findPhone.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.findPhone.bean.PhoneInfo;
import com.jsr.findPhone.dao.PhoneInfoDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午3:00
 * coding for fun and coding my life!
 */
@Repository("PhoneInfoDao")
public class PhoneInfoDaoImpl extends BaseHibernateDao<PhoneInfo,Integer> implements PhoneInfoDao {
    private String HQL = " from PhoneInfo p ";
    private String HQL_FIND_BY_IMEI=HQL+" where p.imeiNo=?";
    @Override
    public PhoneInfo getByImei(String imei) {
        return unique(HQL_FIND_BY_IMEI,imei);
    }
}
