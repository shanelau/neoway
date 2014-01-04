package com.jsr.fota.service;

import com.jsr.common.service.IBaseService;
import com.jsr.fota.bean.FotaFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:39
 * coding for fun and coding my life!
 */
public interface FotaFileService extends IBaseService<FotaFile,Integer> {
    List<FotaFile> listUpdateTo(int versionId);

    FotaFile getByFileIdAndToId(int startVersionId, int versionId);

    Boolean pushToPhone(FotaFile fotaFile,List<String> imes);
}
