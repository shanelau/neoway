package cn.jsr.cloud.service.impl;

import cn.jsr.cloud.bean.City;
import cn.jsr.common.dao.IBaseDao;
import cn.jsr.common.service.impl.BaseService;
import cn.jsr.cloud.dao.CityDao;
import cn.jsr.cloud.service.CityService;
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
@Service("CityService")
public class CityServiceImpl extends BaseService<City,String> implements CityService {
    private CityDao cityDao;
    @Autowired
    @Qualifier("CityDao")
    @Override
    public void setBaseDao(IBaseDao<City,String> baseDao) {
        this.baseDao = baseDao;
        cityDao=(CityDao)baseDao;
    }
    public City findByCityCode(String cityCode){
        return cityDao.findByCityCode(cityCode);
    }
}
