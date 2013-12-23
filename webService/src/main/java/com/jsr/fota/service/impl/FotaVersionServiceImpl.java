package com.jsr.fota.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.pagination.Page;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.fota.bean.FotaVersion;
import com.jsr.fota.dao.FotaVersionDao;
import com.jsr.fota.model.FotaVersionQueryModel;
import com.jsr.fota.service.FotaVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:46
 * coding for fun and coding my life!
 */
@Service("FotaVersionService")
public class FotaVersionServiceImpl extends BaseService<FotaVersion,Integer> implements FotaVersionService {
    FotaVersionDao fotaVersionDao;
    @Autowired
    @Qualifier("FotaVersionDao")
    @Override
    public void setBaseDao(IBaseDao<FotaVersion, Integer> baseDao) {
        this.baseDao = baseDao;
        this.fotaVersionDao = (FotaVersionDao) baseDao;
    }


    @Override
    public Page<FotaVersion> list(int pn, int pageSize, FotaVersionQueryModel fvModel) {
        return fotaVersionDao.listAll(pn,pageSize,fvModel);
    }
}
