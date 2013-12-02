package com.jsr.feedback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-20
 * Time: 上午9:29
 * coding for fun and coding my life!
 */
public class FeedBackConstants {
    public static final int DEFAULT_PAGE_SIZE = 10;


    //反馈的状态
    public static final int FEEDBACK_STATUS_NEW = 1;
    public static final int FEEDBACK_STATUS_REPLYED = 2;
    public static final int FEEDBACK_STATUS_BUG = 3;
    public static final int FEEDBACK_STATUS_CLOSE = 4;

    public static final String STATUS_SUCCESS = "OK";
    public static final String STATUS_FAIL = "FAIL";
    public static final String TAG_STATUS = "status";
    public static final String TAG_MESSAGE = "message";
    public static final String[] RESPONSE_MESSAGE_SUCCESS = new String[]{"提交成功,感谢您的支持!","感谢您对我们工作的大力支持","提交成功,我们会尽快解决问题.","您的信息已经送达,我们会尽快回复您"};
    public static final String[] RESPONSE_MESSAGE_FAIL = new String[]{"哇哦,提交失败,是否网络没开?","很抱歉,服务器出了点小差","出了点小问题,请再次尝试","出了点小状况,我们正在及时补救"};

    //推送设置
    public static final boolean CAN_PUSH_TO_CLENT = true;
    public static final String PUSH_FROM = "feedback server";


    public static Map getMessage(boolean isSuccess,String message){
        Map map = new HashMap();
        if(isSuccess){
            map.put(FeedBackConstants.TAG_STATUS,FeedBackConstants.STATUS_SUCCESS);
            map.put(FeedBackConstants.TAG_MESSAGE, message);
        }else{
            map.put(FeedBackConstants.TAG_STATUS,FeedBackConstants.STATUS_FAIL);
            map.put(FeedBackConstants.TAG_MESSAGE, message);
        }
        return map;
    }
}
