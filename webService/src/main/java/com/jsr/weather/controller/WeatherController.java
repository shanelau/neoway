package com.jsr.weather.controller;

import com.jsr.weather.bean.WeatherLogs;
import com.jsr.weather.bean.WeatherInfo;
import com.jsr.weather.model.WeatherRequestModel;
import com.jsr.weather.service.LogsService;
import com.jsr.weather.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: bean
 * Date: 13-11-1
 * Time: 下午2:17
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/weather")
public class WeatherController {
    @Autowired
    @Qualifier("LogsService")
    LogsService logsService;

    @Autowired
    @Qualifier("WeatherInfoService")
    WeatherInfoService weatherInfoService;

    @RequestMapping(value = "/getWeather", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getWeather(WeatherRequestModel wrModel) {
        String msg = "";
        try {
            msg = saveLogs(wrModel);
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getLocalizedMessage();
        }
        return msg;
    }

    @RequestMapping(value = "/simple/{cityId}/{userId}", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getWeatherSimple(@PathVariable String cityId, @PathVariable String userId) {
        WeatherRequestModel wrModel = new WeatherRequestModel(cityId, true, userId);  //匿名用户
        try {
            return saveLogs(wrModel);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping(value = "/full/{cityId}/{userId}", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getWeatherFull(@PathVariable String cityId, @PathVariable String userId) {
        WeatherRequestModel wrModel = new WeatherRequestModel(cityId, false, userId);  //匿名用户
        try {
            return saveLogs(wrModel);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @param wrModel 请求对象
     * @return 天气信息
     * @throws Exception
     */
    public String saveLogs(WeatherRequestModel wrModel) throws Exception {
        WeatherInfo weatherInfo = weatherInfoService.getWeatherInfo(wrModel);
        WeatherLogs log = new WeatherLogs();                                         //请求信息保存到数据库
        log.setRequestDate(new Timestamp(System.currentTimeMillis()));
        log.setUserId(wrModel.getUserId());
        log.setWeatherInfoByWeId(weatherInfo);     //天气对象
        logsService.saveOrUpdate(log);
        return weatherInfo.getWeInfo();
    }

    /**
     * 匿名访问
     *
     * @param cityId city ID  匿名访问
     * @return
     */
    @RequestMapping(value = "/simple/{cityId}", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getWeatherSimpleAnon(@PathVariable String cityId) {
        WeatherRequestModel wrModel = new WeatherRequestModel(cityId, true, "anon");  //匿名用户
        try {
            return saveLogs(wrModel);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 匿名访问
     *
     * @param cityId city ID  匿名访问
     * @return
     */
    @RequestMapping(value = "/full/{cityId}", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getWeatherFullAnon(@PathVariable String cityId) {
        WeatherRequestModel wrModel = new WeatherRequestModel(cityId, false, "anon");  //匿名用户
        try {
            return saveLogs(wrModel);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
