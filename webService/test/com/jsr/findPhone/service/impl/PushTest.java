package com.jsr.findPhone.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsr.findPhone.FindPhoneConstants;
import com.jsr.pushclient.PushManager;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-16
 * Time: 下午3:05
 * coding for fun and coding my life!
 */
public class PushTest {
    static String imei1 = "A10000075CFBCA";
    static String imei2 = "A1000012345678";
    public static void main(String[] args) throws JsonProcessingException {
       push();
       getOnlineStatus();
    }
    public static String getOnlineStatus(){
        long beginTime = System.currentTimeMillis();
        if(PushManager.getInstance().checkOnlineForImei(imei1)){
            System.out.print("online") ;
        }
        System.out.println(System.currentTimeMillis()-beginTime);
        return "out";
    }
    public static void push() throws JsonProcessingException {
        String message = FindPhoneConstants.getPushMap(FindPhoneConstants.FIND_PHONE_PACKAGE, "lock", "12345678");
        System.out.println(message);
        PushManager.getInstance().sendMessage("findphone",imei1 ,message);
    }
}
