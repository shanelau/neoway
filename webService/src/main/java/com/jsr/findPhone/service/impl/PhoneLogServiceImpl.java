package com.jsr.findPhone.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.findPhone.bean.PhoneLog;
import com.jsr.findPhone.dao.PhoneLogDao;
import com.jsr.findPhone.service.PhoneLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午3:08
 * coding for fun and coding my life!
 */
@Service("PhoneLogService")
public class PhoneLogServiceImpl extends BaseService<PhoneLog,Integer> implements PhoneLogService {
    private PhoneLogDao phoneLogDao;


    @Autowired
    @Qualifier("PhoneLogDao")
    @Override
    public void setBaseDao(IBaseDao<PhoneLog, Integer> baseDao) {
        this.baseDao = baseDao;
        this.phoneLogDao = (PhoneLogDao) baseDao;
    }

    @Override
    public PhoneLog getTopByImei(String imei,String manu,boolean client) {
        return phoneLogDao.getTopByImei(imei,manu,client);
    }
}
