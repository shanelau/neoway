package com.jsr.feedback;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-20
 * Time: 上午9:29
 * coding for fun and coding my life!
 */
public class Constants {
    public static final int DEFAULT_PAGE_SIZE = 10;
    //反馈记录的状态
    public static final int  FEEDBACK_TYPE_ADD = 1;
    public static final int  FEEDBACK_TYPE_ACCEPT =2;
    public static final int  FEEDBACK_TYPE_DEALING = 3;
    public static final int  FEEDBACK_TYPE_DEALED = 4;
    public static final int  FEEDBACK_TYPE_REPLY = 5;
    public static final String STATUS_SUCCESS = "OK";
    public static final String STATUS_FAIL = "FAIL";
    public static final String TAG_STATUS = "status";
    public static final String TAG_MESSAGE = "message";
    public static final String[] RESPONSE_MESSAGE_SUCCESS = new String[]{"提交成功,感谢您的支持!","感谢您对我们工作的大力支持","提交成功,我们会尽快解决问题.","您的信息已经送达,我们会尽快回复您"};
    public static final String[] RESPONSE_MESSAGE_FAIL = new String[]{"哇哦,提交失败,是否网络没开?","很抱歉,服务器出了点小差","出了点小问题,请再次尝试","出了点小状况,我们正在及时补救"};

}
