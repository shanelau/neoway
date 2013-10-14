package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.cloud.dao.SoftwareInfoDao;
import cn.neoway.cloud.service.SoftwareInfoService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 下午2:09
 * To change this template use File | Settings | File Templates.
 */
@Service("SoftwareInfoService")
public class SoftwareInfoServiceImpl extends BaseService<SoftwareInfo,Integer> implements SoftwareInfoService{
    SoftwareInfoDao softwareInfoDao;
    @Qualifier("SoftwareInfoDao")
    @Autowired
    @Override
    public void setBaseDao(IBaseDao<SoftwareInfo, Integer> baseDao) {
        this.baseDao = baseDao;
        this.softwareInfoDao = (SoftwareInfoDao) baseDao;
    }

    @Override
    public List<SoftwareInfo> getNullFileByTypeId() {
        return softwareInfoDao.getNullFileByTypeId();
    }
}
