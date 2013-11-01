package cn.jsr.cloud.dao;

import cn.jsr.cloud.bean.WeatherInfo;
import cn.jsr.common.dao.IBaseDao;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:08
 * To change this template use File | Settings | File Templates.
 */
public interface WeatherInfoDao extends IBaseDao<WeatherInfo,Integer>{

    WeatherInfo findWeather(String cityCode, Boolean simple, Timestamp timestamp);
}
