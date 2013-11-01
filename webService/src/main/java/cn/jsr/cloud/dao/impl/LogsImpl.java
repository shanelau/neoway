package cn.jsr.cloud.dao.impl;

import cn.jsr.cloud.bean.Logs;
import cn.jsr.common.dao.hibernate4.BaseHibernateDao;
import cn.jsr.cloud.dao.LogsDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:09
 * To change this template use File | Settings | File Templates.
 */
@Repository("LogsDao")
public class LogsImpl extends BaseHibernateDao<Logs,Integer> implements LogsDao {

}
