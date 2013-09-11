package cn.neoway.common.shiro.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-11
 * Time: 上午9:47
 * To change this template use File | Settings | File Templates.
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
    private String captcha;

    public CaptchaUsernamePasswordToken(String username, String password,String captcha) {
        super(username, password);
        this.captcha = captcha;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
