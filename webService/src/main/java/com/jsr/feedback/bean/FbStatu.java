package com.jsr.feedback.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-19
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "fb_statu", schema = "")
@Entity
public class FbStatu extends AbstractModel {
    private int statusId;

    @javax.persistence.Column(name = "status_Id")
    @Id
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    private String statusName;

    @javax.persistence.Column(name = "status_Name")
    @Basic
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private String statusDesc;

    @javax.persistence.Column(name = "status_Desc")
    @Basic
    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FbStatu fbStatu = (FbStatu) o;

        if (statusId != fbStatu.statusId) return false;
        if (statusDesc != null ? !statusDesc.equals(fbStatu.statusDesc) : fbStatu.statusDesc != null) return false;
        if (statusName != null ? !statusName.equals(fbStatu.statusName) : fbStatu.statusName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + (statusName != null ? statusName.hashCode() : 0);
        result = 31 * result + (statusDesc != null ? statusDesc.hashCode() : 0);
        return result;
    }

    private Collection<FbFeedbacks> fbFeedbacksesByStatusId;

    @OneToMany(mappedBy = "fbStatuByStatusId")
    public Collection<FbFeedbacks> getFbFeedbacksesByStatusId() {
        return fbFeedbacksesByStatusId;
    }

    public void setFbFeedbacksesByStatusId(Collection<FbFeedbacks> fbFeedbacksesByStatusId) {
        this.fbFeedbacksesByStatusId = fbFeedbacksesByStatusId;
    }
}
