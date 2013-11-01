package cn.jsr.cloud.service;

import cn.jsr.cloud.bean.City;
import cn.jsr.common.service.IBaseService;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午9:12
 * To change this template use File | Settings | File Templates.
 */
public interface CityService extends IBaseService<City,String>{
    public City findByCityCode(String cityCode);
}
