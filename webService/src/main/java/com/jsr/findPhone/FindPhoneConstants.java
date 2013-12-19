package com.jsr.findPhone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午4:47
 * coding for fun and coding my life!
 */
public class FindPhoneConstants {
    public static final String  TAG_STATUS = "status";
    public static final String  STATUS_SUCCESS = "OK";
    public static final String  STATUS_FAIL = "FAIL";
    public static final long PUSH_LOCATION_ITERVAL =2*60*1000;  //location push间隔
    public static final long LOCATION_EXPIRY_DATE =10*60*1000;  //数据有效时间

    public static final long PUSH_OTHER_ITERVAL =1*10*1000;  //其他 push间隔
    public static final long PUSH_OTHER_EXPIRY_DATE =1*10*1000;   //其他有效时间

    public static final String  LOCATION = "location";
    public static final String  LOCK = "lock";
    public static final String  VOICE = "voice";
    public static final String  CLEAN = "clean";
    public static final String  PUSH_FROM = "find phone system";
    public static final String  FIND_PHONE_PACKAGE = "com.jsr.push.findphone";


    public static final String  TAG_MESSAGE = "message";

    public static Map getMessage(boolean isSuccess,Object message){
        Map map = new HashMap();
        if(isSuccess){
            map.put(TAG_STATUS,STATUS_SUCCESS);
            map.put(TAG_MESSAGE, message);
        }else{
            map.put(TAG_STATUS,STATUS_FAIL);
            map.put(TAG_MESSAGE, message);
        }
        return map;
    }


    static Map  pushMap = new HashMap();  //推送的map
    static ObjectMapper objectMapper = new ObjectMapper();
    /**
     *
     *
     * @param message    要推送的消息
     * @param value
     * @return   json 对象
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public static String getPushMap(String action, String message, Object value) throws JsonProcessingException {
        pushMap.clear();
        pushMap.put("action", action);
        pushMap.put("message",message);
        pushMap.put("value",value);
        pushMap.put("date",System.currentTimeMillis());
        return objectMapper.writeValueAsString(pushMap);
    }
    public static void main(String[] args) throws JsonProcessingException {
        System.out.print(getPushMap(FIND_PHONE_PACKAGE, LOCATION, "open"));
    }
}
