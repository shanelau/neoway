package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "manu_log", schema = "", catalog = "neoway")
@Entity
public class ManuLog extends AbstractModel {
    private int manuId;

    @javax.persistence.Column(name = "manu_id")
    @Id
    public int getManuId() {
        return manuId;
    }

    public void setManuId(int manuId) {
        this.manuId = manuId;
    }

    private String manuIp;

    @javax.persistence.Column(name = "manu_ip")
    @Basic
    public String getManuIp() {
        return manuIp;
    }

    public void setManuIp(String manuIp) {
        this.manuIp = manuIp;
    }

    private String manuDesc;

    @javax.persistence.Column(name = "manu_desc")
    @Basic
    public String getManuDesc() {
        return manuDesc;
    }

    public void setManuDesc(String manuDesc) {
        this.manuDesc = manuDesc;
    }

    private Timestamp manuDate;

    @javax.persistence.Column(name = "manu_date")
    @Basic
    public Timestamp getManuDate() {
        return manuDate;
    }

    public void setManuDate(Timestamp manuDate) {
        this.manuDate = manuDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManuLog manuLog = (ManuLog) o;

        if (manuId != manuLog.manuId) return false;
        if (manuDate != null ? !manuDate.equals(manuLog.manuDate) : manuLog.manuDate != null) return false;
        if (manuDesc != null ? !manuDesc.equals(manuLog.manuDesc) : manuLog.manuDesc != null) return false;
        if (manuIp != null ? !manuIp.equals(manuLog.manuIp) : manuLog.manuIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manuId;
        result = 31 * result + (manuIp != null ? manuIp.hashCode() : 0);
        result = 31 * result + (manuDesc != null ? manuDesc.hashCode() : 0);
        result = 31 * result + (manuDate != null ? manuDate.hashCode() : 0);
        return result;
    }

    private Users usersByUserId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    private ManuType manuTypeByManuTypeId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "manu_type_id", referencedColumnName = "manu_type_id")
    public ManuType getManuTypeByManuTypeId() {
        return manuTypeByManuTypeId;
    }

    public void setManuTypeByManuTypeId(ManuType manuTypeByManuTypeId) {
        this.manuTypeByManuTypeId = manuTypeByManuTypeId;
    }
}
