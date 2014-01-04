package com.jsr.fota.dao;

import com.jsr.common.dao.IBaseDao;
import com.jsr.fota.bean.FotaFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:31
 * coding for fun and coding my life!
 */
public interface FotaFileDao extends IBaseDao<FotaFile,Integer> {
    List<FotaFile> listUpdateTo(int versionId, int brandId);

    FotaFile getByFileIdAndToId(int startVersionId, int versionId);
}
