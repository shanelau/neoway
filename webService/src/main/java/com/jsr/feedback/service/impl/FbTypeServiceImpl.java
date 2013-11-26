package com.jsr.feedback.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.FbType;
import com.jsr.feedback.dao.FbTypeDao;
import com.jsr.feedback.service.FbTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-20
 * Time: 上午8:51
 * coding for fun and coding my life!
 */
@Service("FbTypeService")
public class FbTypeServiceImpl extends BaseService<FbType, Integer> implements FbTypeService {
    FbTypeDao fbTypeDao;

    @Autowired
    @Qualifier("FbTypeDao")
    @Override
    public void setBaseDao(IBaseDao<FbType, Integer> baseDao) {
        this.baseDao = baseDao;
        this.fbTypeDao = (FbTypeDao) baseDao;
    }
}
