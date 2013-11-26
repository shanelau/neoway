package com.jsr.weather.model;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 下午2:02
 * To change this template use File | Settings | File Templates.
 */
public class WeatherRequestModel {
    private String cityCode;
    private Boolean simple;
    private String userId;

    public WeatherRequestModel() {
    }

    public WeatherRequestModel(String cityCode, Boolean simple, String userId) {
        this.cityCode = cityCode;
        this.simple = simple;
        this.userId = userId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Boolean getSimple() {
        return simple;
    }

    public void setSimple(Boolean simple) {
        this.simple = simple;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
