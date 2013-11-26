package com.jsr.weather.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "weather_info", schema = "", catalog = "jsr_rom_db")
@Entity
public class WeatherInfo extends AbstractModel {
    private int weId;
    private String weInfo;
    private Boolean simple;
    private Timestamp updateTime;
    private Collection<WeatherLogs> logsesByWeId;
    private City cityByCityCode;

    @javax.persistence.Column(name = "we_Id")
    @Id
    @GeneratedValue
    public int getWeId() {
        return weId;
    }

    public void setWeId(int weId) {
        this.weId = weId;
    }

    @javax.persistence.Column(name = "we_Info")
    @Basic
    public String getWeInfo() {
        return weInfo;
    }

    public void setWeInfo(String weInfo) {
        this.weInfo = weInfo;
    }

    @javax.persistence.Column(name = "simple")
    @Basic
    public Boolean getSimple() {
        return simple;
    }

    public void setSimple(Boolean simple) {
        this.simple = simple;
    }

    @javax.persistence.Column(name = "update_time")
    @Basic
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherInfo that = (WeatherInfo) o;

        if (weId != that.weId) return false;
        if (simple != null ? !simple.equals(that.simple) : that.simple != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (weInfo != null ? !weInfo.equals(that.weInfo) : that.weInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weId;
        result = 31 * result + (weInfo != null ? weInfo.hashCode() : 0);
        result = 31 * result + (simple != null ? simple.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "weatherInfoByWeId")
    public Collection<WeatherLogs> getLogsesByWeId() {
        return logsesByWeId;
    }

    public void setLogsesByWeId(Collection<WeatherLogs> logsesByWeId) {
        this.logsesByWeId = logsesByWeId;
    }

    @ManyToOne
    @JoinColumn(name = "city_code", referencedColumnName = "city_code")
    public City getCityByCityCode() {
        return cityByCityCode;
    }

    public void setCityByCityCode(City cityByCityCode) {
        this.cityByCityCode = cityByCityCode;
    }
}
