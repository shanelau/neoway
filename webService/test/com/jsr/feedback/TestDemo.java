package com.jsr.feedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsr.pushclient.PushManager;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class TestDemo {
    Map  pushMap = new HashMap()  ;
    ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) {
        try {
            PushManager.getInstance().sendMessage("demo", "A10000075CFBCA", new TestDemo().getPushMap("json推送测试"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public  String getPushMap(String message) throws JsonProcessingException {
        pushMap.clear();
        pushMap.put("action",FeedBackConstants.FEEDBACK_PACKAGE);
        pushMap.put("message",message);
        return objectMapper.writeValueAsString(pushMap);
    }

}
