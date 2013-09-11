package cn.neoway.cloud.model;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-10
 * Time: 下午8:51
 * To change this template use File | Settings | File Templates.
 */
public class LoginCommand {
    private String username;
    private String password;

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
}
