package cn.neoway.cloud.model;

import cn.neoway.common.model.AbstractModel;

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
}
