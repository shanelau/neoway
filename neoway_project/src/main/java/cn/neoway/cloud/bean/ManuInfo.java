package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "manu_info", schema = "", catalog = "neoway")
@Entity
public class ManuInfo extends AbstractModel{
    private int manuInfoId;
    private String manuState;
    private Boolean isReback;
    private String rebackInfo;
    private String updateInfo;
    private Boolean isBackCheck;
    private String manuNotice;
    private Timestamp manuInfoDate;
    private Collection<Project> projectsByManuInfoId;
    private String manuProcedure;

    @OneToMany(mappedBy="manuInfoByManuInfoId")
    public Collection<Project> getProjectsByManuInfoId(){
        return  projectsByManuInfoId;
    }
    public void setProjectsByManuInfoId(Collection<Project> projectsByManuInfoId){
        this. projectsByManuInfoId = projectsByManuInfoId;
    }

    @Column(name = "manu_info_id")
    @Id
    @GeneratedValue
    public int getManuInfoId() {
        return manuInfoId;
    }

    public void setManuInfoId(int manuInfoId) {
        this.manuInfoId = manuInfoId;
    }

    @Column(name = "manu_state")
    @Basic
    public String getManuState() {
        return manuState;
    }

    public void setManuState(String manuState) {
        this.manuState = manuState;
    }

    @Column(name = "is_reback")
    @Basic
    public Boolean getReback() {
        return isReback;
    }

    public void setReback(Boolean reback) {
        isReback = reback;
    }

    @Column(name = "reback_info")
    @Basic
    public String getRebackInfo() {
        return rebackInfo;
    }

    public void setRebackInfo(String rebackInfo) {
        this.rebackInfo = rebackInfo;
    }

    @Column(name = "update_info")
    @Basic
    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    @Column(name = "is_back_check")
    @Basic
    public Boolean getBackCheck() {
        return isBackCheck;
    }

    public void setBackCheck(Boolean backCheck) {
        isBackCheck = backCheck;
    }

    @Column(name = "manu_notice")
    @Basic
    public String getManuNotice() {
        return manuNotice;
    }

    public void setManuNotice(String manuNotice) {
        this.manuNotice = manuNotice;
    }

    @Column(name = "manu_info_date")
    @Basic
    public Timestamp getManuInfoDate() {
        return manuInfoDate;
    }
    @Column(name = "manu_procedure")
    @Basic
    public String getManuProcedure() {
        return manuProcedure;
    }
    public void setManuProcedure(String manuProcedure){
        this.manuProcedure = manuProcedure;
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
}
