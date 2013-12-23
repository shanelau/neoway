package com.jsr.fota.dao;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.pagination.Page;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.fota.bean.FotaVersion;
import com.jsr.fota.model.FotaVersionQueryModel;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:42
 * coding for fun and coding my life!
 */
public interface FotaVersionDao extends IBaseDao<FotaVersion,Integer>{
    Page<FotaVersion> listAll(int pn, int pageSize, FotaVersionQueryModel fvModel);
}
