package com.jsr.fota.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.fota.bean.FotaBrand;
import com.jsr.fota.dao.FotaBrandDao;
import com.jsr.fota.service.FotaBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:44
 * coding for fun and coding my life!
 */
 @Service("FotaBrandService")
public class FotaBrandServiceImpl extends BaseService<FotaBrand,Integer> implements FotaBrandService {
    FotaBrandDao fotaBrandDao;
    @Autowired
    @Qualifier("FotaBrandDao")
    @Override
    public void setBaseDao(IBaseDao<FotaBrand, Integer> baseDao) {
        this.baseDao =baseDao;
        this.fotaBrandDao = (FotaBrandDao) baseDao;
    }



}
