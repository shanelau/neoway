package com.jsr.findPhone.service;

import com.jsr.common.service.IBaseService;
import com.jsr.findPhone.bean.PhoneInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午3:01
 * coding for fun and coding my life!
 */
public interface PhoneInfoService extends IBaseService<PhoneInfo,Integer>{
    PhoneInfo getByImei(String imei);

    List<PhoneInfo> getByUsername(String username);
}
