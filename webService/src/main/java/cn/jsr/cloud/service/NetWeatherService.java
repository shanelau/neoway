package cn.jsr.cloud.service;

import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-31
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 */
@Service("NetWeatherService")
public class NetWeatherService {
    private static String URL_SIMPLE_WEATHER = "http://www.weather.com.cn/data/sk/";      //实时天气
    private static String URL_FULL_WEATHER = "http://m.weather.com.cn/data/";              //6天天气
    private static String URL_SUFFIX = ".html";
    private static NetWeatherService mNetWeatherService;
    private InputStream inputStream;
    private URL url;
    private HttpURLConnection connection;

/*    private NetWeatherService() {

    }
    public static NetWeatherService getInstance(){
        if(mNetWeatherService == null){
            mNetWeatherService = new NetWeatherService();
        }
        return mNetWeatherService;
    }*/

    /**
     * 获取天气数据
     * @param cityId  城市编号
     * @param isSimply 是否为简单数据。true为实时天气。false未近6天天气
     * @returnt 天气json 字符串
     */
    public  String getCityWeather(String cityId,Boolean isSimply) throws Exception {
        String htmlContent = "";
            String urlString = getUrl(cityId, isSimply);
           // System.out.println(urlString);
            url = new java.net.URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            byte bytes[] = new byte[1024 * 2000];
            int index = 0;
            int count = inputStream.read(bytes, index, 1024 * 2000);
            while (count != -1) {
                index += count;
                count = inputStream.read(bytes, index, 1);
            }
            htmlContent = new String(bytes, "UTF-8");
            connection.disconnect();

        return htmlContent.trim();
    }

    /**
     *   获取完整url
     * @param cityId      城市编号
     * @param simply     是否为简单天气
     * @return           完整URL
     */
    private  String getUrl(String cityId, Boolean simply) {
        if(cityId == null){
                throw new NullPointerException("city is required");
        }
        if(simply){
           return URL_SIMPLE_WEATHER+cityId+URL_SUFFIX;
        }else{
            return URL_FULL_WEATHER+cityId+URL_SUFFIX;
        }
    }
}

