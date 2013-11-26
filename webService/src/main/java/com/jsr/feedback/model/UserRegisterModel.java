package com.jsr.feedback.model;


import com.jsr.common.model.AbstractModel;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-11
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
public class UserRegisterModel extends AbstractModel {
    private String username;
    private String password;
    private String email;
    private String trueName;
    private String dept;
    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
