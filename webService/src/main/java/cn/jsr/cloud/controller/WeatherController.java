package cn.jsr.cloud.controller;

import cn.jsr.cloud.bean.Logs;
import cn.jsr.cloud.bean.WeatherInfo;
import cn.jsr.cloud.exception.NoCityFoundException;
import cn.jsr.cloud.model.WeatherRequestModel;
import cn.jsr.cloud.service.LogsService;
import cn.jsr.cloud.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: ak
 * Date: 13-11-1
 * Time: 下午2:17
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WeatherController {
    @Autowired
    @Qualifier("LogsService")
    LogsService logsService;

    @Autowired
    @Qualifier("WeatherInfoService")
    WeatherInfoService weatherInfoService;
    PrintWriter out;

    @RequestMapping(value = "/getWeather",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public void getWeather(WeatherRequestModel wrModel,HttpServletResponse response){
        WeatherInfo wi;
        try {
            out = response.getWriter();
            wi =  weatherInfoService.getWeatherInfo(wrModel);
            Logs log = new Logs();                                         //请求信息保存到数据库
            log.setRequestDate(new Timestamp(System.currentTimeMillis()));
            log.setUserId(wrModel.getUserId());
            log.setWeatherInfoByWeId(wi);
            logsService.saveOrUpdate(log);
            out.print(wi.getWeInfo());
        } catch (NoCityFoundException e) {
            e.printStackTrace();
            out.print(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            out.print(e.getMessage());
        } catch (Exception e) {
            out.print(e.getMessage());
            e.printStackTrace();
        }
    }
}
