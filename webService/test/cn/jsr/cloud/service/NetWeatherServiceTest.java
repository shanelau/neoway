package cn.jsr.cloud.service;

import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-31
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class NetWeatherServiceTest {
    NetWeatherService netWeatherService;
/*    @Before
    public void init(){
        netWeatherService = NetWeatherService.getInstance();
    }*/
    @Test
    public void testGetCityWeather() throws Exception {
        String cityId = "101010100";//北京
        String result = netWeatherService.getCityWeather(cityId,false);
        System.out.println(result);
    }

}
