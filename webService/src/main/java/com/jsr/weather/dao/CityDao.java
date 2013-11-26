package com.jsr.weather.dao;

import com.jsr.weather.bean.City;
import com.jsr.common.dao.IBaseDao;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:08
 * To change this template use File | Settings | File Templates.
 */
public interface CityDao extends IBaseDao<City, String> {

    City findByCityCode(String cityCode);
}
