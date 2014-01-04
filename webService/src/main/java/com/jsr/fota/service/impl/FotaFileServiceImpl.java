package com.jsr.fota.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.fota.FotaConstants;
import com.jsr.fota.bean.FotaFile;
import com.jsr.fota.bean.FotaVersion;
import com.jsr.fota.dao.FotaFileDao;
import com.jsr.fota.service.FotaFileService;
import com.jsr.fota.service.FotaVersionService;
import com.jsr.pushclient.PushManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Qualifier("FotaVersionService")
    FotaVersionService fotaVersionService;

    @Autowired
    @Qualifier("FotaFileDao")
    @Override
    public void setBaseDao(IBaseDao<FotaFile, Integer> baseDao) {
        this.baseDao = baseDao;
        this.fotaFileDao = (FotaFileDao) baseDao;
    }

    @Override
    public List<FotaFile> listUpdateTo(int versionId) {
        FotaVersion fotaVersion = fotaVersionService.get(versionId);
        return fotaFileDao.listUpdateTo(versionId,fotaVersion.getFotaBrandByBrandId().getBrandId());
    }

    @Override
    public FotaFile getByFileIdAndToId(int startVersionId, int versionId) {
        return fotaFileDao.getByFileIdAndToId(startVersionId,versionId);
    }

    @Override
    public Boolean pushToPhone(FotaFile fotaFile,List<String> imes) {
        FotaVersion fv = fotaVersionService.get(fotaFile.getUpdateTo());
        try {
            String message = FotaConstants.getPushMap(fotaFile,fv.getVersionName());
            PushManager.getInstance().sendMessage(FotaConstants.PUSH_FROM,imes,message);
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return false;

    }

}
