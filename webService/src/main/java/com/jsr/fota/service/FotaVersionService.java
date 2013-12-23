package com.jsr.fota.service;

import com.jsr.common.pagination.Page;
import com.jsr.common.service.IBaseService;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.fota.bean.FotaVersion;
import com.jsr.fota.model.FotaVersionQueryModel;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:40
 * coding for fun and coding my life!
 */
public interface FotaVersionService extends IBaseService<FotaVersion,Integer> {
    Page<FotaVersion> list(int pn, int pageSize, FotaVersionQueryModel fvModel);
}
