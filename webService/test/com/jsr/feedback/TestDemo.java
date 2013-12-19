package com.jsr.feedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsr.pushclient.PushManager;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class TestDemo {

	public static void main(String[] args) {
        try {
            PushManager.getInstance().sendMessage("demo", "A10000075CFBCA",FeedBackConstants.getPushMap("json推送测试json推送测试json推送测试json推送测试json推送测试json推送测试"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
