package com.jsr.fota.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 上午11:55
 * coding for fun and coding my life!
 */
@javax.persistence.Table(name = "fota_log", schema = "")
@Entity
public class FotaLog extends AbstractModel {
    private int logId;

    @javax.persistence.Column(name = "log_Id")
    @Id
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    private String versionFrom;

    @javax.persistence.Column(name = "version_From")
    @Basic
    public String getVersionFrom() {
        return versionFrom;
    }

    public void setVersionFrom(String versionFrom) {
        this.versionFrom = versionFrom;
    }

    private String versionTo;

    @javax.persistence.Column(name = "version_To")
    @Basic
    public String getVersionTo() {
        return versionTo;
    }

    public void setVersionTo(String versionTo) {
        this.versionTo = versionTo;
    }

    private Timestamp content;

    @javax.persistence.Column(name = "content")
    @Basic
    public Timestamp getContent() {
        return content;
    }

    public void setContent(Timestamp content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FotaLog fotaLog = (FotaLog) o;

        if (logId != fotaLog.logId) return false;
        if (content != null ? !content.equals(fotaLog.content) : fotaLog.content != null) return false;
        if (versionFrom != null ? !versionFrom.equals(fotaLog.versionFrom) : fotaLog.versionFrom != null) return false;
        if (versionTo != null ? !versionTo.equals(fotaLog.versionTo) : fotaLog.versionTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId;
        result = 31 * result + (versionFrom != null ? versionFrom.hashCode() : 0);
        result = 31 * result + (versionTo != null ? versionTo.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
