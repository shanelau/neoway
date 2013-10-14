package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.SoftwareType;
import cn.neoway.cloud.dao.SoftwareTypeDao;
import cn.neoway.cloud.service.SoftwareTypeService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
@Service("SoftwareTypeService")
public class SoftwareTypeServiceImpl extends BaseService<SoftwareType,Integer> implements SoftwareTypeService {
    SoftwareTypeDao softwareTypeDao;
    @Autowired
    @Qualifier("SoftwareTypeDao")
    @Override
    public void setBaseDao(IBaseDao<SoftwareType, Integer> baseDao) {
        this.baseDao = baseDao;
        this.softwareTypeDao = (SoftwareTypeDao) baseDao;
    }
}
