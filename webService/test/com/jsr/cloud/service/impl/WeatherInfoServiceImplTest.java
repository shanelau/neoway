package com.jsr.cloud.service.impl;

import com.jsr.weather.bean.WeatherInfo;
import com.jsr.weather.exception.NoCityFoundException;
import com.jsr.weather.service.CityService;
import com.jsr.weather.service.NetWeatherService;
import com.jsr.weather.service.WeatherInfoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:26
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class WeatherInfoServiceImplTest {
    @Autowired
    @Qualifier("WeatherInfoService")
    WeatherInfoService weatherInfoService;

    @Autowired
    @Qualifier("NetWeatherService")
    NetWeatherService netWeatherService;

    @Autowired
    @Qualifier("CityService")
    CityService cityService;

    @Test
    public void testInsert() throws Exception {
        String cityCode = "101010100";
        Boolean isSimple = true;
        String content = netWeatherService.getCityWeather(cityCode, isSimple);

        if (content.contains("html")) {
            throw new NoCityFoundException("there is no city on weatherService,please check city_code");
        }
        WeatherInfo wi = new WeatherInfo();
        wi.setWeInfo(content);
        wi.setCityByCityCode(cityService.get(cityCode));
        wi.setSimple(isSimple);
        wi.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        weatherInfoService.save(wi);
    }

    @Test
    public void query() {
        List<WeatherInfo> list = weatherInfoService.listAll();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(gson.toJson(list));
    }


}
