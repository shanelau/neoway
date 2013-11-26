package com.jsr.cloud.service.impl;

import com.jsr.weather.bean.WeatherLogs;
import com.jsr.weather.bean.WeatherInfo;
import com.jsr.weather.exception.NoCityFoundException;
import com.jsr.weather.model.WeatherRequestModel;
import com.jsr.weather.service.LogsService;
import com.jsr.weather.service.WeatherInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 下午2:25
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class LogsServiceImplTest {

    @Autowired
    @Qualifier("LogsService")
    LogsService logsService;

    @Autowired
    @Qualifier("WeatherInfoService")
    WeatherInfoService weatherInfoService;

    @Test
    public void getWeather() {
        WeatherRequestModel wrModel = new WeatherRequestModel();
        wrModel.setUserId("liux23");
        wrModel.setSimple(true);
        wrModel.setCityCode("101010300");
        WeatherInfo wi;
        try {
            wi = weatherInfoService.getWeatherInfo(wrModel);
            WeatherLogs log = new WeatherLogs();                                         //请求信息保存到数据库
            log.setRequestDate(new Timestamp(System.currentTimeMillis()));
            log.setUserId(wrModel.getUserId());
            log.setWeatherInfoByWeId(wi);
            logsService.saveOrUpdate(log);
        } catch (NoCityFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
