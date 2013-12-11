package com.jsr.findPhone.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.findPhone.bean.PhoneInfo;
import com.jsr.findPhone.dao.PhoneInfoDao;
import com.jsr.findPhone.service.PhoneInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午3:02
 * coding for fun and coding my life!
 */
@Service("PhoneInfoService")
public class PhoneInfoServiceImpl extends BaseService<PhoneInfo,Integer> implements PhoneInfoService {
    private PhoneInfoDao phoneInfoDao;
    @Autowired
    @Qualifier("PhoneInfoDao")
    @Override
    public void setBaseDao(IBaseDao<PhoneInfo, Integer> baseDao) {
          this.baseDao = baseDao;
        this.phoneInfoDao = (PhoneInfoDao) baseDao;
    }


    @Override
    public PhoneInfo getByImei(String imei) {
        return phoneInfoDao.getByImei(imei);    }

    @Override
    public List<PhoneInfo> getByUsername(String username) {
       return phoneInfoDao.listByUsername(username);
    }
}
