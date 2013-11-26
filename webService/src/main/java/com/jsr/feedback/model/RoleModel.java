package com.jsr.feedback.model;


import com.jsr.feedback.bean.Roles;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-5
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class RoleModel {
    Roles roles;
    boolean containt;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public boolean isContaint() {
        return containt;
    }

    public void setContaint(boolean containt) {
        this.containt = containt;
    }
}
