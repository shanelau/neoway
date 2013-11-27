package com.jsr.feedback.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jsr.common.model.AbstractModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-19
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "fb_feedbacks", schema = "", catalog = "jsr_rom_db")
@Entity
public class FbFeedbacks extends AbstractModel {
    private int fbId;

    @javax.persistence.Column(name = "fb_Id")
    @Id
    @GeneratedValue
    public int getFbId() {
        return fbId;
    }

    public void setFbId(int fbId) {
        this.fbId = fbId;
    }

    private String subject;

    @javax.persistence.Column(name = "subject")
    @Basic
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    private String imgPath;

    @javax.persistence.Column(name = "img_Path")
    @Basic
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    private String version;

    @javax.persistence.Column(name = "version")
    @Basic
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private Timestamp fbDate;

    @javax.persistence.Column(name = "fb_date")
    @Basic
    public Timestamp getFbDate() {
        return fbDate;
    }

    public void setFbDate(Timestamp fbDate) {
        this.fbDate = fbDate;
    }

    private String phImei;

    @javax.persistence.Column(name = "ph_Imei")
    @Basic
    public String getPhImei() {
        return phImei;
    }

    public void setPhImei(String phImei) {
        this.phImei = phImei;
    }
    private String logPath;
    @javax.persistence.Column(name = "log_Path")
    @Basic
    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
    private String contact;
    @javax.persistence.Column(name = "contact")
    @Basic
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FbFeedbacks that = (FbFeedbacks) o;

        if (fbId != that.fbId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (fbDate != null ? !fbDate.equals(that.fbDate) : that.fbDate != null) return false;
        if (imgPath != null ? !imgPath.equals(that.imgPath) : that.imgPath != null) return false;
        if (phImei != null ? !phImei.equals(that.phImei) : that.phImei != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (logPath != null ? !logPath.equals(that.logPath) : that.logPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fbId;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (fbDate != null ? fbDate.hashCode() : 0);
        result = 31 * result + (phImei != null ? phImei.hashCode() : 0);
        result = 31 * result + (logPath != null ? logPath.hashCode() : 0);
        return result;
    }

    private Collection<FbAnswer> fbAnswersByFbId;

    @JsonIgnore
    @OneToMany(mappedBy = "fbFeedbacksByFbId")
    public Collection<FbAnswer> getFbAnswersByFbId() {
        return fbAnswersByFbId;
    }

    public void setFbAnswersByFbId(Collection<FbAnswer> fbAnswersByFbId) {
        this.fbAnswersByFbId = fbAnswersByFbId;
    }

    private FbType fbTypeByTypeId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "type_Id", referencedColumnName = "type_Id")
    public FbType getFbTypeByTypeId() {
        return fbTypeByTypeId;
    }

    public void setFbTypeByTypeId(FbType fbTypeByTypeId) {
        this.fbTypeByTypeId = fbTypeByTypeId;
    }

    private FbStatu fbStatuByStatusId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "status_Id", referencedColumnName = "status_Id")
    public FbStatu getFbStatuByStatusId() {
        return fbStatuByStatusId;
    }

    public void setFbStatuByStatusId(FbStatu fbStatuByStatusId) {
        this.fbStatuByStatusId = fbStatuByStatusId;
    }
}
