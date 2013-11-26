package com.jsr.feedback.bean;

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
@javax.persistence.Table(name = "users", schema = "", catalog = "jsr_rom_db")
@Entity
public class Users extends AbstractModel {
    private int userId;

    @javax.persistence.Column(name = "user_Id")
    @Id
    @GeneratedValue
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String userName;

    @javax.persistence.Column(name = "user_Name")
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

    private String phone;

    @javax.persistence.Column(name = "phone")
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String nick;

    @javax.persistence.Column(name = "nick")
    @Basic
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    private String trueName;

    @javax.persistence.Column(name = "true_Name")
    @Basic
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    private String sex;

    @javax.persistence.Column(name = "sex")
    @Basic
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String other;

    @javax.persistence.Column(name = "other")
    @Basic
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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
    private Boolean statu;

    @javax.persistence.Column(name = "statu")
    @Basic
    public Boolean getStatu() {
        return statu;
    }

    public void setStatu(Boolean statu) {
        this.statu = statu;
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
    private Timestamp regDate;

    @javax.persistence.Column(name = "reg_date")
    @Basic
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (nick != null ? !nick.equals(users.nick) : users.nick != null) return false;
        if (other != null ? !other.equals(users.other) : users.other != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (sex != null ? !sex.equals(users.sex) : users.sex != null) return false;
        if (trueName != null ? !trueName.equals(users.trueName) : users.trueName != null) return false;
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) return false;
        if (dept != null ? !dept.equals(users.dept) : users.dept != null) return false;
        if (statu != null ? !statu.equals(users.statu) : users.statu != null) return false;
        if (validataCode != null ? !validataCode.equals(users.validataCode) : users.validataCode != null) return false;
        if (regDate != null ? !regDate.equals(users.regDate) : users.regDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (statu != null ? statu.hashCode() : 0);
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        result = 31 * result + (validataCode != null ? validataCode.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        return result;
    }

    private Collection<FbAnswer> fbAnswersByUserId;

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<FbAnswer> getFbAnswersByUserId() {
        return fbAnswersByUserId;
    }

    public void setFbAnswersByUserId(Collection<FbAnswer> fbAnswersByUserId) {
        this.fbAnswersByUserId = fbAnswersByUserId;
    }

    private Collection<UsersRoles> usersRolesesByUserId;

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UsersRoles> getUsersRolesesByUserId() {
        return usersRolesesByUserId;
    }

    public void setUsersRolesesByUserId(Collection<UsersRoles> usersRolesesByUserId) {
        this.usersRolesesByUserId = usersRolesesByUserId;
    }
}
