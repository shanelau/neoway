package com.jsr.fota.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.fota.bean.FotaImei;
import com.jsr.fota.dao.FotaImeiDao;
import com.jsr.fota.service.FotaImeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-25
 * Time: 下午4:41
 * coding for fun and coding my life!
 */
@Service("FotaImeiService")
public class FotaImeiServiceImpl extends BaseService<FotaImei,String> implements FotaImeiService {
    FotaImeiDao fotaImeiDao;
    @Autowired
    @Qualifier("FotaImeiDao")
    @Override
    public void setBaseDao(IBaseDao<FotaImei, String> baseDao) {
        this.baseDao = baseDao;
        this.fotaImeiDao = (FotaImeiDao) baseDao;
    }
}
