package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.PlanUserType;
import cn.neoway.cloud.dao.PlanUserTypeDao;
import cn.neoway.cloud.service.PlanUserTypeService;
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
@Service("PlanUserTypeService")
public class PlanUserTypeServiceImpl extends BaseService<PlanUserType,Integer> implements PlanUserTypeService {
    PlanUserTypeDao planUserTypeDao;

    @Autowired
    @Qualifier("PlanUserTypeDao")
    @Override
    public void setBaseDao(IBaseDao<PlanUserType, Integer> baseDao) {
          this.baseDao = baseDao;
           this.planUserTypeDao = (PlanUserTypeDao) baseDao;
    }
}
