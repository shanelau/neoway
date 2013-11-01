package cn.jsr.cloud.service;

import cn.jsr.cloud.bean.WeatherInfo;
import cn.jsr.common.service.IBaseService;
import cn.jsr.cloud.exception.NoCityFoundException;
import cn.jsr.cloud.model.WeatherRequestModel;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:12
 * To change this template use File | Settings | File Templates.
 */
public interface WeatherInfoService extends IBaseService<WeatherInfo,Integer>{
     public WeatherInfo getWeatherInfo(WeatherRequestModel wrModel) throws Exception;
}
