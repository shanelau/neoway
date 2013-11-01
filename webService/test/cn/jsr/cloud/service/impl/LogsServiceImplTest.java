package cn.jsr.cloud.service.impl;

import cn.jsr.cloud.bean.Logs;
import cn.jsr.cloud.bean.WeatherInfo;
import cn.jsr.cloud.exception.NoCityFoundException;
import cn.jsr.cloud.model.WeatherRequestModel;
import cn.jsr.cloud.service.LogsService;
import cn.jsr.cloud.service.WeatherInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void getWeather(){
        WeatherRequestModel wrModel = new WeatherRequestModel();
        wrModel.setUserId("liux23");
        wrModel.setSimple(true);
        wrModel.setCityCode("101010300");
        WeatherInfo wi;
        try {
            wi =  weatherInfoService.getWeatherInfo(wrModel);
            Logs log = new Logs();                                         //请求信息保存到数据库
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
