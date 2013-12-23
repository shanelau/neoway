package com.jsr.fota.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.fota.bean.FotaFile;
import com.jsr.fota.dao.FotaFileDao;
import com.jsr.fota.service.FotaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:45
 * coding for fun and coding my life!
 */
@Service("FotaFileService")
public class FotaFileServiceImpl extends BaseService<FotaFile,Integer> implements FotaFileService {
    FotaFileDao fotaFileDao;
    @Autowired
    @Qualifier("FotaFileDao")
    @Override
    public void setBaseDao(IBaseDao<FotaFile, Integer> baseDao) {
        this.baseDao = baseDao;
        this.fotaFileDao = (FotaFileDao) baseDao;
    }
}
