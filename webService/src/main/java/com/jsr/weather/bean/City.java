package com.jsr.weather.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "city", schema = "")
@Entity
public class City extends AbstractModel {
    private String cityCode;
    private String cityName;
    private Collection<WeatherInfo> weatherInfosByCityCode;

    @javax.persistence.Column(name = "city_code")
    @Id
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @javax.persistence.Column(name = "city_Name")
    @Basic
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (cityCode != null ? !cityCode.equals(city.cityCode) : city.cityCode != null) return false;
        if (cityName != null ? !cityName.equals(city.cityName) : city.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityCode != null ? cityCode.hashCode() : 0;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cityByCityCode")
    public Collection<WeatherInfo> getWeatherInfosByCityCode() {
        return weatherInfosByCityCode;
    }

    public void setWeatherInfosByCityCode(Collection<WeatherInfo> weatherInfosByCityCode) {
        this.weatherInfosByCityCode = weatherInfosByCityCode;
    }
}
