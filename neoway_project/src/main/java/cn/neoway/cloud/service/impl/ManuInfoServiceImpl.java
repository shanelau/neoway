package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.ManuInfo;
import cn.neoway.cloud.dao.ManuInfoDao;
import cn.neoway.cloud.service.ManuInfoService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */
@Service("ManuInfoService")
public class ManuInfoServiceImpl extends BaseService<ManuInfo,Integer> implements ManuInfoService {

    ManuInfoDao manuInfoDao;
    @Autowired
    @Qualifier("ManuInfoDao")
    @Override
    public void setBaseDao(IBaseDao<ManuInfo, Integer> baseDao) {
        this.baseDao = baseDao;
        this.manuInfoDao = (ManuInfoDao) baseDao;
    }
}
