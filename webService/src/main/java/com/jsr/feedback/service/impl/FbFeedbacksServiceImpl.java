package com.jsr.feedback.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.pagination.Page;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.dao.FbFeedbacksDao;
import com.jsr.feedback.model.FBQueryModel;
import com.jsr.feedback.service.FbFeedbacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-19
 * Time: 下午9:53
 * coding for fun and coding my life!
 */
@Service("FbFeedbacksService")
public class FbFeedbacksServiceImpl extends BaseService<FbFeedbacks, Integer> implements FbFeedbacksService {

    FbFeedbacksDao fbFeedbacksDao;

    @Autowired
    @Qualifier("FbFeedbacksDao")
    @Override
    public void setBaseDao(IBaseDao<FbFeedbacks, Integer> baseDao) {
        this.baseDao = baseDao;
        fbFeedbacksDao = (FbFeedbacksDao) baseDao;
    }

    @Override
    public Page<FbFeedbacks> listAll(int pn, int pageSize, String search, String order) {

        return fbFeedbacksDao.listAll(pn,pageSize,search,order);
    }

    @Override
    public Page<FbFeedbacks> list(int pn, int pageSize, FBQueryModel fbQueryModel) {
        return  fbFeedbacksDao.list(pn,pageSize,fbQueryModel);
    }
}
