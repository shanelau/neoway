package com.jsr.findPhone.dao;

import com.jsr.common.dao.IBaseDao;
import com.jsr.findPhone.bean.PhoneInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午2:58
 * coding for fun and coding my life!
 */
public interface PhoneInfoDao extends IBaseDao<PhoneInfo,Integer>{
    PhoneInfo getByImei(String imei);

    List<PhoneInfo> listByUsername(String username);
}
