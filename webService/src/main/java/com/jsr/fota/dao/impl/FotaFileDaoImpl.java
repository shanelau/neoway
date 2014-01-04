package com.jsr.fota.dao.impl;

import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.fota.bean.FotaFile;
import com.jsr.fota.dao.FotaFileDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:32
 * coding for fun and coding my life!
 */
@Repository("FotaFileDao")
public class FotaFileDaoImpl extends BaseHibernateDao<FotaFile,Integer> implements FotaFileDao {
    String HQL_LIST_CAN_UPDATE_TO_VERSION = " from FotaFile ff where ff.updateTo = ? and ff.fotaVersionByVersionId.fotaBrandByBrandId.brandId = ?";
    String HQL_FIND_FILE = " from FotaFile ff where ff.fotaVersionByVersionId.versionId = ? and ff.updateTo =?";
    @Override
    public List<FotaFile> listUpdateTo(int versionId, int brandId) {
        return list(HQL_LIST_CAN_UPDATE_TO_VERSION,-1,-1,versionId,brandId);
    }

    @Override
    public FotaFile getByFileIdAndToId(int startVersionId, int versionId) {
        return unique(HQL_FIND_FILE,startVersionId,versionId);
    }
}
