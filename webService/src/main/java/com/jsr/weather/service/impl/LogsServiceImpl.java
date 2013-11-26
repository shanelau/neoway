package com.jsr.weather.service.impl;

import com.jsr.weather.bean.WeatherLogs;
import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.weather.dao.LogsDao;
import com.jsr.weather.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:13
 * To change this template use File | Settings | File Templates.
 */
@Service("LogsService")
public class LogsServiceImpl extends BaseService<WeatherLogs, Integer> implements LogsService {
    private LogsDao logsDao;

    @Autowired
    @Qualifier("LogsDao")
    @Override
    public void setBaseDao(IBaseDao<WeatherLogs, Integer> baseDao) {
        this.baseDao = baseDao;
        logsDao = (LogsDao) baseDao;
    }
}
