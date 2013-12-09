package com.jsr.findPhone.service;

import com.jsr.common.service.IBaseService;
import com.jsr.findPhone.bean.PhoneLog;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午3:06
 * coding for fun and coding my life!
 */
public interface PhoneLogService extends IBaseService<PhoneLog,Integer> {
    /**
     *
     * @param imei    imei
     * @param manu    操作名字
     * @param client  是否为客户端上传的数据
     * @return
     */
    PhoneLog getTopByImei(String imei,String manu,boolean client);
}
