package com.jsr.weather.service;

import com.jsr.weather.bean.City;
import com.jsr.common.service.IBaseService;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:12
 * To change this template use File | Settings | File Templates.
 */
public interface CityService extends IBaseService<City, String> {
    public City findByCityCode(String cityCode);
}
