package cn.jsr.cloud.bean;

import cn.jsr.common.model.AbstractModel;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "logs", schema = "", catalog = "weather_cloud_db")
@Entity
public class Logs extends AbstractModel {
    private int logId;
    private String userId;
    private Timestamp requestDate;
    private WeatherInfo weatherInfoByWeId;

    @javax.persistence.Column(name = "log_id")
    @Id
    @GeneratedValue
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @javax.persistence.Column(name = "user_id")
    @Basic
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @javax.persistence.Column(name = "request_date")
    @Basic
    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logs logs = (Logs) o;

        if (logId != logs.logId) return false;
        if (requestDate != null ? !requestDate.equals(logs.requestDate) : logs.requestDate != null) return false;
        if (userId != null ? !userId.equals(logs.userId) : logs.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "we_Id", referencedColumnName = "we_Id",insertable = true,updatable = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public WeatherInfo getWeatherInfoByWeId() {
        return weatherInfoByWeId;
    }

    public void setWeatherInfoByWeId(WeatherInfo weatherInfoByWeId) {
        this.weatherInfoByWeId = weatherInfoByWeId;
    }
}
