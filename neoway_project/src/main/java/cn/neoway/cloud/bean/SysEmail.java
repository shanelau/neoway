package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "sys_email", schema = "", catalog = "neoway")
@Entity
public class SysEmail extends AbstractModel {
    private Integer emailId;

    @javax.persistence.Column(name = "email_id")
    @Id
    @GeneratedValue
    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    private String sendTo;

    @javax.persistence.Column(name = "send_to")
    @Basic
    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    private String emailTitle;

    @javax.persistence.Column(name = "email_title")
    @Basic
    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
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

    private Timestamp sendTime;

    @javax.persistence.Column(name = "send_time")
    @Basic
    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysEmail sysEmail = (SysEmail) o;

        if (content != null ? !content.equals(sysEmail.content) : sysEmail.content != null) return false;
        if (emailId != null ? !emailId.equals(sysEmail.emailId) : sysEmail.emailId != null) return false;
        if (emailTitle != null ? !emailTitle.equals(sysEmail.emailTitle) : sysEmail.emailTitle != null) return false;
        if (sendTime != null ? !sendTime.equals(sysEmail.sendTime) : sysEmail.sendTime != null) return false;
        if (sendTo != null ? !sendTo.equals(sysEmail.sendTo) : sysEmail.sendTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailId != null ? emailId.hashCode() : 0;
        result = 31 * result + (sendTo != null ? sendTo.hashCode() : 0);
        result = 31 * result + (emailTitle != null ? emailTitle.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        return result;
    }
}
