package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.SmtTiepianInfo;
import cn.neoway.cloud.dao.SmtTiepianInfoDao;
import cn.neoway.cloud.service.SmtTitpianInfoService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 上午11:39
 * To change this template use File | Settings | File Templates.
 */
@Service("SmtTitpianInfoService")
public class SmtTitpianInfoServiceImpl extends BaseService<SmtTiepianInfo,Integer> implements SmtTitpianInfoService{
    SmtTiepianInfoDao smtTiepianInfoDao;
    @Autowired
    @Qualifier("SmtTiepianInfoDao")
    @Override
    public void setBaseDao(IBaseDao<SmtTiepianInfo, Integer> baseDao) {
          this.baseDao = baseDao;
          this.smtTiepianInfoDao = (SmtTiepianInfoDao) baseDao;
    }
}
