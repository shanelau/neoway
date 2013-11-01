package cn.jsr.cloud.dao.impl;

import cn.jsr.cloud.bean.City;
import cn.jsr.common.dao.hibernate4.BaseHibernateDao;
import cn.jsr.cloud.dao.CityDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:09
 * To change this template use File | Settings | File Templates.
 */
@Repository("CityDao")
public class CityDaoImpl extends BaseHibernateDao<City,String> implements CityDao {
    private static String FIND_UNIQUE_BY_CITY_CODE = " from City c where c.cityCode=?";
    @Override
    public City findByCityCode(String cityCode) {
        return unique(FIND_UNIQUE_BY_CITY_CODE,cityCode);
    }
}
