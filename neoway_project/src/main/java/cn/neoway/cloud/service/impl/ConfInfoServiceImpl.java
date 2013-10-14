package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.ConfInfo;
import cn.neoway.cloud.dao.ConfInfoDao;
import cn.neoway.cloud.service.ConfInfoService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
@Service("ConfInfoService")
public class ConfInfoServiceImpl extends BaseService<ConfInfo,Integer> implements ConfInfoService {
    ConfInfoDao confInfoDao;
    @Autowired
    @Qualifier("ConfInfoDao")
    @Override
    public void setBaseDao(IBaseDao<ConfInfo, Integer> baseDao) {
          this.baseDao = baseDao;
           this.confInfoDao = (ConfInfoDao) baseDao;
    }
}
