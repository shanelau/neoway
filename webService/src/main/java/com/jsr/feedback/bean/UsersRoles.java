package com.jsr.feedback.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-19
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(com.jsr.feedback.bean.UsersRolesPK.class)
@javax.persistence.Table(name = "users_roles", schema = "", catalog = "jsr_rom_db")
@Entity
public class UsersRoles extends AbstractModel {
    private int userId;

    @javax.persistence.Column(name = "user_Id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int roleId;

    @javax.persistence.Column(name = "role_Id")
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersRoles that = (UsersRoles) o;

        if (roleId != that.roleId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + roleId;
        return result;
    }

    private Roles rolesByRoleId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "role_Id", referencedColumnName = "role_Id", nullable = false, updatable = false, insertable = false)
    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }

    private Users usersByUserId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "user_Id", referencedColumnName = "user_Id", nullable = false, updatable = false, insertable = false)
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
