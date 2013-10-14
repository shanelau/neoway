package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.ProSoftList;
import cn.neoway.cloud.dao.ProSoftListDao;
import cn.neoway.cloud.service.ProSoftListService;
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
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
@Service("ProSoftListService")
public class ProSoftListServiceImpl extends BaseService<ProSoftList,Integer> implements ProSoftListService {
    ProSoftListDao proSoftListDao;
    @Autowired
    @Qualifier("ProSoftListDao")
    @Override
    public void setBaseDao(IBaseDao<ProSoftList, Integer> baseDao) {
        this.baseDao = baseDao;
        this.proSoftListDao = (ProSoftListDao) baseDao;
    }

    @Override
    public List<ProSoftList> findByProPlanId(int id) {
        return proSoftListDao.findByProPlanId(id);
    }

    @Override
    public void saveProList(int proPlanId, List<ProSoftList> proSoftList) {
             deleteByProPlanId(proPlanId);           //删除所有记录  再保存新数据
                 for(ProSoftList softList :proSoftList){
                     save(softList);
                 }

    }

    @Override
    public void deleteByProPlanId(int planId) {
         proSoftListDao.deleteByPlanId(planId);
    }
}
