package com.jsr.feedback.dao;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.pagination.Page;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.model.FBQueryModel;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-19
 * Time: 下午9:49
 * coding for fun and coding my life!
 */
public interface FbFeedbacksDao extends IBaseDao<FbFeedbacks, Integer> {

    Page<FbFeedbacks> listAll(int pn, int pageSize, String search, String order);

    Page<FbFeedbacks> list(int pn, int pageSize, FBQueryModel fbQueryModel);
}
