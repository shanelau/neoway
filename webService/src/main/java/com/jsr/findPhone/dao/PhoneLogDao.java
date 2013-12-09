package com.jsr.findPhone.dao;

import com.jsr.common.dao.IBaseDao;
import com.jsr.findPhone.bean.PhoneLog;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午3:04
 * coding for fun and coding my life!
 */
public interface PhoneLogDao extends IBaseDao<PhoneLog,Integer>{
    PhoneLog getTopByImei(String imei,String manu,boolean client);
}
