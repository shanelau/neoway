package com.jsr.weather.service.impl;

import com.jsr.weather.bean.WeatherInfo;
import com.jsr.common.Constants;
import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.weather.dao.WeatherInfoDao;
import com.jsr.weather.exception.NoCityFoundException;
import com.jsr.weather.model.WeatherRequestModel;
import com.jsr.weather.service.CityService;
import com.jsr.weather.service.NetWeatherService;
import com.jsr.weather.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:13
 * To change this template use File | Settings | File Templates.
 */
@Service("WeatherInfoService")
public class WeatherInfoServiceImpl extends BaseService<WeatherInfo, Integer> implements WeatherInfoService {
    private WeatherInfoDao weatherInfoDao;

    @Autowired
    @Qualifier("NetWeatherService")
    NetWeatherService netWeatherService;
    @Autowired
    @Qualifier("CityService")
    CityService cityService;


    @Autowired
    @Qualifier("WeatherInfoDao")
    @Override
    public void setBaseDao(IBaseDao<WeatherInfo, Integer> baseDao) {
        this.baseDao = baseDao;
        weatherInfoDao = (WeatherInfoDao) baseDao;
    }

    /**
     * 获取天气数据。 如果数据库存在 并且更新时间在30分钟内，则直接返回。否则请求新的数据。
     *
     * @param wrModel 城市编号
     * @return
     */
    @Override
    public WeatherInfo getWeatherInfo(WeatherRequestModel wrModel) throws Exception {
        WeatherInfo wi = getWeatherFromDB(wrModel);
        if (wi == null) {
            wi = getNetWeather(wrModel.getCityCode(), wrModel.getSimple());
        }
        return wi;
    }

    public WeatherInfo getWeatherFromDB(WeatherRequestModel wrModel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() - Constants.REQUEST_WEATHER_MINITER * 60 * 1000); //在指定直接内,连续请求，将直接返回数据库内数据
        return weatherInfoDao.findWeather(wrModel.getCityCode(), wrModel.getSimple(), timestamp);
    }

    public WeatherInfo getNetWeather(String cityCode, Boolean isSimple) throws Exception {
        String content = netWeatherService.getCityWeather(cityCode, isSimple);
        if (content.contains("html")) {
            throw new NoCityFoundException("there is no city on weatherService,please check city_code");
        }
        WeatherInfo wi = new WeatherInfo();
        wi.setWeInfo(content);
        wi.setCityByCityCode(cityService.get(cityCode));
        wi.setSimple(isSimple);
        wi.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return wi;
    }
}
