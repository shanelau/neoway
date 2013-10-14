package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.SysEmail;
import cn.neoway.cloud.dao.SysEmailDao;
import cn.neoway.cloud.service.SysEmailService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-8
 * Time: 上午8:43
 * To change this template use File | Settings | File Templates.
 */
@Service("SysEmailService")
public class SysEmailServiceImpl extends BaseService<SysEmail,Integer> implements SysEmailService{
    private SysEmailDao sysEmailDao;
    @Autowired
    @Qualifier("SysEmailDao")
    @Override
    public void setBaseDao(IBaseDao<SysEmail, Integer> baseDao) {
        this.baseDao = baseDao;
        this.sysEmailDao = (SysEmailDao) baseDao;
    }
}
