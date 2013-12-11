package com.jsr.findPhone.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.findPhone.bean.PhoneInfo;
import com.jsr.findPhone.dao.PhoneInfoDao;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    private String HQL_FIND_BY_USER_ID=HQL+" where p.usersByUserId.userName=?";

    @Override
    public PhoneInfo getByImei(String imei) {
        return unique(HQL_FIND_BY_IMEI,imei);
    }

    @Override
    public List<PhoneInfo> listByUsername(String username) {
        return list(HQL_FIND_BY_USER_ID,-1,-1,username);
    }
}
