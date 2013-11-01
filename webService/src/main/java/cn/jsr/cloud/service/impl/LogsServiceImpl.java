package cn.jsr.cloud.service.impl;

import cn.jsr.cloud.bean.Logs;
import cn.jsr.common.dao.IBaseDao;
import cn.jsr.common.service.impl.BaseService;
import cn.jsr.cloud.dao.LogsDao;
import cn.jsr.cloud.service.LogsService;
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
public class LogsServiceImpl extends BaseService<Logs,Integer> implements LogsService {
    private LogsDao logsDao;
    @Autowired
    @Qualifier("LogsDao")
    @Override
    public void setBaseDao(IBaseDao<Logs,Integer> baseDao) {
        this.baseDao = baseDao;
        logsDao=(LogsDao)baseDao;
    }
}
