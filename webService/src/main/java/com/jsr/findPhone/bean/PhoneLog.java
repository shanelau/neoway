package com.jsr.findPhone.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午2:45
 * coding for fun and coding my life!
 */
@javax.persistence.Table(name = "phone_log")
@Entity
public class PhoneLog extends AbstractModel{
    private int logId;

    @javax.persistence.Column(name = "log_Id")
    @Id
    @GeneratedValue
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }
    private String name;

    @javax.persistence.Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String content;

    @javax.persistence.Column(name = "content")
    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Timestamp logTime;

    @javax.persistence.Column(name = "log_Time")
    @Basic
    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }
    private String pointX;

    @javax.persistence.Column(name = "pointX")
    @Basic
    public String getPointX() {
        return pointX;
    }

    public void setPointX(String pointX) {
        this.pointX = pointX;
    }

    private String pointY;

    @javax.persistence.Column(name = "pointY")
    @Basic
    public String getPointY() {
        return pointY;
    }

    public void setPointY(String pointY) {
        this.pointY = pointY;
    }

    private Boolean online;

    @javax.persistence.Column(name = "online")
    @Basic
    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    private Boolean client;

    @javax.persistence.Column(name = "client")
    @Basic
    public Boolean getClient() {
        return client;
    }

    public void setClient(Boolean client) {
        this.client = client;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneLog phoneLog = (PhoneLog) o;

        if (logId != phoneLog.logId) return false;
        if (content != null ? !content.equals(phoneLog.content) : phoneLog.content != null) return false;
        if (logTime != null ? !logTime.equals(phoneLog.logTime) : phoneLog.logTime != null) return false;
        if (name != null ? !name.equals(phoneLog.name) : phoneLog.name != null) return false;
        if (pointX != null ? !pointX.equals(phoneLog.pointX) : phoneLog.pointX != null) return false;
        if (pointY != null ? !pointY.equals(phoneLog.pointY) : phoneLog.pointY != null) return false;
        if (online != null ? !online.equals(phoneLog.online) : phoneLog.online != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = logId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (logTime != null ? logTime.hashCode() : 0);
        result = 31 * result + (pointX != null ? pointX.hashCode() : 0);
        result = 31 * result + (pointY != null ? pointY.hashCode() : 0);
        result = 31 * result + (online != null ? online.hashCode() : 0);
        return result;
    }

    private PhoneInfo phoneInfoByPhId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "ph_Id", referencedColumnName = "ph_Id")
    public PhoneInfo getPhoneInfoByPhId() {
        return phoneInfoByPhId;
    }

    public void setPhoneInfoByPhId(PhoneInfo phoneInfoByPhId) {
        this.phoneInfoByPhId = phoneInfoByPhId;
    }
}
