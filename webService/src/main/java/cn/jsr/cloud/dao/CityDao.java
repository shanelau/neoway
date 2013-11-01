package cn.jsr.cloud.dao;

import cn.jsr.cloud.bean.City;
import cn.jsr.common.dao.IBaseDao;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:08
 * To change this template use File | Settings | File Templates.
 */
public interface CityDao extends IBaseDao<City,String>{

    City findByCityCode(String cityCode);
}
