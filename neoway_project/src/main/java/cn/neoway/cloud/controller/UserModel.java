package cn.neoway.cloud.controller;

import java.security.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-23
 * Time: 下午9:18
 * To change this template use File | Settings | File Templates.
 */
public class UserModel {
    private Boolean username;
    private Integer password;

    public Boolean getUsername() {
        return username;
    }

    public void setUsername(Boolean username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
