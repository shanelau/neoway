package cn.neoway.cloud.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "manu_info", schema = "", catalog = "neoway")
@Entity
public class ManuInfo {
    private int manuInfoId;

    @javax.persistence.Column(name = "manu_info_id")
    @Id
    public int getManuInfoId() {
        return manuInfoId;
    }

    public void setManuInfoId(int manuInfoId) {
        this.manuInfoId = manuInfoId;
    }

    private String manuState;

    @javax.persistence.Column(name = "manu_state")
    @Basic
    public String getManuState() {
        return manuState;
    }

    public void setManuState(String manuState) {
        this.manuState = manuState;
    }

    private Boolean isReback;

    @javax.persistence.Column(name = "is_reback")
    @Basic
    public Boolean getReback() {
        return isReback;
    }

    public void setReback(Boolean reback) {
        isReback = reback;
    }

    private String rebackInfo;

    @javax.persistence.Column(name = "reback_info")
    @Basic
    public String getRebackInfo() {
        return rebackInfo;
    }

    public void setRebackInfo(String rebackInfo) {
        this.rebackInfo = rebackInfo;
    }

    private String updateInfo;

    @javax.persistence.Column(name = "update_info")
    @Basic
    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    private Boolean isBackCheck;

    @javax.persistence.Column(name = "is_back_check")
    @Basic
    public Boolean getBackCheck() {
        return isBackCheck;
    }

    public void setBackCheck(Boolean backCheck) {
        isBackCheck = backCheck;
    }

    private String manuNotice;

    @javax.persistence.Column(name = "manu_notice")
    @Basic
    public String getManuNotice() {
        return manuNotice;
    }

    public void setManuNotice(String manuNotice) {
        this.manuNotice = manuNotice;
    }

    private Timestamp manuInfoDate;

    @javax.persistence.Column(name = "manu_info_date")
    @Basic
    public Timestamp getManuInfoDate() {
        return manuInfoDate;
    }

    public void setManuInfoDate(Timestamp manuInfoDate) {
        this.manuInfoDate = manuInfoDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManuInfo manuInfo = (ManuInfo) o;

        if (manuInfoId != manuInfo.manuInfoId) return false;
        if (isBackCheck != null ? !isBackCheck.equals(manuInfo.isBackCheck) : manuInfo.isBackCheck != null)
            return false;
        if (isReback != null ? !isReback.equals(manuInfo.isReback) : manuInfo.isReback != null) return false;
        if (manuInfoDate != null ? !manuInfoDate.equals(manuInfo.manuInfoDate) : manuInfo.manuInfoDate != null)
            return false;
        if (manuNotice != null ? !manuNotice.equals(manuInfo.manuNotice) : manuInfo.manuNotice != null) return false;
        if (manuState != null ? !manuState.equals(manuInfo.manuState) : manuInfo.manuState != null) return false;
        if (rebackInfo != null ? !rebackInfo.equals(manuInfo.rebackInfo) : manuInfo.rebackInfo != null) return false;
        if (updateInfo != null ? !updateInfo.equals(manuInfo.updateInfo) : manuInfo.updateInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manuInfoId;
        result = 31 * result + (manuState != null ? manuState.hashCode() : 0);
        result = 31 * result + (isReback != null ? isReback.hashCode() : 0);
        result = 31 * result + (rebackInfo != null ? rebackInfo.hashCode() : 0);
        result = 31 * result + (updateInfo != null ? updateInfo.hashCode() : 0);
        result = 31 * result + (isBackCheck != null ? isBackCheck.hashCode() : 0);
        result = 31 * result + (manuNotice != null ? manuNotice.hashCode() : 0);
        result = 31 * result + (manuInfoDate != null ? manuInfoDate.hashCode() : 0);
        return result;
    }

    private ProProcedure proProcedureByProceId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "proce_id", referencedColumnName = "proce_id")
    public ProProcedure getProProcedureByProceId() {
        return proProcedureByProceId;
    }

    public void setProProcedureByProceId(ProProcedure proProcedureByProceId) {
        this.proProcedureByProceId = proProcedureByProceId;
    }

    private Collection<ProSoftList> proSoftListsByManuInfoId;

    @OneToMany(mappedBy = "manuInfoByManuInfoId")
    public Collection<ProSoftList> getProSoftListsByManuInfoId() {
        return proSoftListsByManuInfoId;
    }


    public void setProSoftListsByManuInfoId(Collection<ProSoftList> proSoftListsByManuInfoId) {
        this.proSoftListsByManuInfoId = proSoftListsByManuInfoId;
    }

    private Collection<Project> projectsByManuInfoId;

    @OneToMany(mappedBy = "manuInfoByManuInfoId")
    public Collection<Project> getProjectsByManuInfoId() {
        return projectsByManuInfoId;
    }

    public void setProjectsByManuInfoId(Collection<Project> projectsByManuInfoId) {
        this.projectsByManuInfoId = projectsByManuInfoId;
    }
}
