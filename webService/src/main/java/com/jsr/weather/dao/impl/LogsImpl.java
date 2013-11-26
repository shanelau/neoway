package com.jsr.weather.dao.impl;

import com.jsr.weather.bean.WeatherLogs;
import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.weather.dao.LogsDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:09
 * To change this template use File | Settings | File Templates.
 */
@Repository("LogsDao")
public class LogsImpl extends BaseHibernateDao<WeatherLogs, Integer> implements LogsDao {

}
