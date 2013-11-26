package com.jsr.weather.service;

import com.jsr.weather.bean.WeatherInfo;
import com.jsr.common.service.IBaseService;
import com.jsr.weather.model.WeatherRequestModel;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:12
 * To change this template use File | Settings | File Templates.
 */
public interface WeatherInfoService extends IBaseService<WeatherInfo, Integer> {
    public WeatherInfo getWeatherInfo(WeatherRequestModel wrModel) throws Exception;

}
