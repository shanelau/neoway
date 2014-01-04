package com.jsr.fota;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsr.fota.bean.FotaFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午3:55
 * coding for fun and coding my life!
 */
public class FotaConstants {
    public static final String  PUSH_FROM = "fota manager system";
    public static final String  FOTA_PACKAGE = "com.jsr.push.fota";


    public static Map getMessage(Boolean success,Object obj){
       Map map = new HashMap<String,Object>();
       map.put("status",success);
       map.put("obj",obj);
       return map;
   }
    //推送map
    static Map  pushMap = new HashMap();  //推送的map
    static ObjectMapper objectMapper = new ObjectMapper();
    public static String getPushMap(FotaFile fotaFile,String toFotaVersionName) throws JsonProcessingException {
        pushMap.clear();
        pushMap.put("action",FOTA_PACKAGE);
        pushMap.put("startVersion",fotaFile.getFotaVersionByVersionId().getVersionName());
        pushMap.put("updateToVersion",toFotaVersionName);
        pushMap.put("fileUrl",fotaFile.getUrl());
        pushMap.put("fileSize",fotaFile.getSize());
        pushMap.put("updateDesc",fotaFile.getFotaVersionByVersionId().getVersionDesc());
        return objectMapper.writeValueAsString(pushMap);
    }

}
