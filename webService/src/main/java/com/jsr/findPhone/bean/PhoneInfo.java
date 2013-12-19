package com.jsr.findPhone.bean;

import com.jsr.common.model.AbstractModel;
import com.jsr.feedback.bean.Users;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午2:45
 * coding for fun and coding my life!
 */
@javax.persistence.Table(name = "phone_info")
@Entity
public class PhoneInfo extends AbstractModel{
    private int phId;

    @javax.persistence.Column(name = "ph_Id")
    @Id
    @GeneratedValue
    public int getPhId() {
        return phId;
    }

    public void setPhId(int phId) {
        this.phId = phId;
    }

    private String imeiNo;

    @javax.persistence.Column(name = "imei_No")
    @Basic
    public String getImeiNo() {
        return imeiNo;
    }

    public void setImeiNo(String imeiNo) {
        this.imeiNo = imeiNo;
    }

    private String phoneNo;

    @javax.persistence.Column(name = "phone_No")
    @Basic
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    private Timestamp bindTime;

    @javax.persistence.Column(name = "bind_Time")
    @Basic
    public Timestamp getBindTime() {
        return bindTime;
    }

    public void setBindTime(Timestamp bindTime) {
        this.bindTime = bindTime;
    }
    private String phoneModel;
    @javax.persistence.Column(name = "phone_model")
    @Basic
    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneInfo phoneInfo = (PhoneInfo) o;

        if (phId != phoneInfo.phId) return false;
        if (bindTime != null ? !bindTime.equals(phoneInfo.bindTime) : phoneInfo.bindTime != null) return false;
        if (imeiNo != null ? !imeiNo.equals(phoneInfo.imeiNo) : phoneInfo.imeiNo != null) return false;
        if (phoneNo != null ? !phoneNo.equals(phoneInfo.phoneNo) : phoneInfo.phoneNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phId;
        result = 31 * result + (imeiNo != null ? imeiNo.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (bindTime != null ? bindTime.hashCode() : 0);

        return result;
    }
    private Collection<PhoneLog> phoneLogsByPhId;

    @OneToMany(mappedBy = "phoneInfoByPhId")
    public Collection<PhoneLog> getPhoneLogsByPhId() {
        return phoneLogsByPhId;
    }

    public void setPhoneLogsByPhId(Collection<PhoneLog> phoneLogsByPhId) {
        this.phoneLogsByPhId = phoneLogsByPhId;
    }

    private Users usersByUserId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
