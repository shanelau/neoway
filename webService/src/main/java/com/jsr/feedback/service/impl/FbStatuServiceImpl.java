package com.jsr.feedback.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.FbStatu;
import com.jsr.feedback.dao.FbStatuDao;
import com.jsr.feedback.service.FbStatuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-20
 * Time: 上午8:47
 * coding for fun and coding my life!
 */
@Service("FbStatuService")
public class FbStatuServiceImpl extends BaseService<FbStatu, Integer> implements FbStatuService {
    FbStatuDao fbStatuDao;

    @Autowired
    @Qualifier("FbStatuDao")
    @Override
    public void setBaseDao(IBaseDao<FbStatu, Integer> baseDao) {
        this.baseDao = baseDao;
        this.fbStatuDao = (FbStatuDao) baseDao;
    }
}
