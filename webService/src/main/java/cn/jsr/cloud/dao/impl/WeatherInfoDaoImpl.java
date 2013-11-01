package cn.jsr.cloud.dao.impl;

import cn.jsr.cloud.bean.WeatherInfo;
import cn.jsr.cloud.dao.WeatherInfoDao;
import cn.jsr.common.dao.hibernate4.BaseHibernateDao;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:09
 * To change this template use File | Settings | File Templates.
 */
@Repository("WeatherInfoDao")
public class WeatherInfoDaoImpl extends BaseHibernateDao<WeatherInfo,Integer> implements WeatherInfoDao{
    public static String FIND_WEATHER_BY_CITY_CODE_AND_DATE=" from WeatherInfo w where w.cityByCityCode.cityCode=? and" +
            " w.simple=? and w.updateTime > ? order by w.updateTime desc";
    @Override
    public WeatherInfo findWeather(String cityCode, Boolean simple, Timestamp timestamp) {
        return unique(FIND_WEATHER_BY_CITY_CODE_AND_DATE,cityCode,simple,timestamp);
    }
}
