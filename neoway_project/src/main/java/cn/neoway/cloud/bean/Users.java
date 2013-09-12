package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Users extends AbstractModel{
    private int userId;

    @javax.persistence.Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String userName;

    @javax.persistence.Column(name = "user_name")
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String password;

    @javax.persistence.Column(name = "password")
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;

    @javax.persistence.Column(name = "email")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String trueName;

    @javax.persistence.Column(name = "true_name")
    @Basic
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    private String dept;

    @javax.persistence.Column(name = "dept")
    @Basic
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    private Timestamp registerDate;

    @javax.persistence.Column(name = "register_date")
    @Basic
    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    private String validataCode;

    @javax.persistence.Column(name = "validata_code")
    @Basic
    public String getValidataCode() {
        return validataCode;
    }

    public void setValidataCode(String validataCode) {
        this.validataCode = validataCode;
    }

    private Boolean userState;

    @javax.persistence.Column(name = "user_state")
    @Basic
    public Boolean getUserState() {
        return userState;
    }

    public void setUserState(Boolean userState) {
        this.userState = userState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (dept != null ? !dept.equals(users.dept) : users.dept != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (registerDate != null ? !registerDate.equals(users.registerDate) : users.registerDate != null) return false;
        if (trueName != null ? !trueName.equals(users.trueName) : users.trueName != null) return false;
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) return false;
        if (userState != null ? !userState.equals(users.userState) : users.userState != null) return false;
        if (validataCode != null ? !validataCode.equals(users.validataCode) : users.validataCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (validataCode != null ? validataCode.hashCode() : 0);
        result = 31 * result + (userState != null ? userState.hashCode() : 0);
        return result;
    }

    private Collection<ManuLog> manuLogsByUserId;

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<ManuLog> getManuLogsByUserId() {
        return manuLogsByUserId;
    }

    public void setManuLogsByUserId(Collection<ManuLog> manuLogsByUserId) {
        this.manuLogsByUserId = manuLogsByUserId;
    }

    private Collection<PlanUser> planUsersByUserId;

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<PlanUser> getPlanUsersByUserId() {
        return planUsersByUserId;
    }

    public void setPlanUsersByUserId(Collection<PlanUser> planUsersByUserId) {
        this.planUsersByUserId = planUsersByUserId;
    }

    private Collection<UserRoles> userRolesesByUserId;

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserRoles> getUserRolesesByUserId() {
        return userRolesesByUserId;
    }

    public void setUserRolesesByUserId(Collection<UserRoles> userRolesesByUserId) {
        this.userRolesesByUserId = userRolesesByUserId;
    }
}
