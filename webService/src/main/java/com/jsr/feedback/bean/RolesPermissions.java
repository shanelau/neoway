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
@javax.persistence.IdClass(com.jsr.feedback.bean.RolesPermissionsPK.class)
@javax.persistence.Table(name = "roles_permissions", schema = "")
@Entity
public class RolesPermissions extends AbstractModel {
    private int roleId;

    @javax.persistence.Column(name = "role_Id")
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    private int permId;

    @javax.persistence.Column(name = "perm_Id")
    @Id
    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesPermissions that = (RolesPermissions) o;

        if (permId != that.permId) return false;
        if (roleId != that.roleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + permId;
        return result;
    }

    private Permissions permissionsByPermId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "perm_Id", referencedColumnName = "perm_Id", nullable = false, updatable = false, insertable = false)
    public Permissions getPermissionsByPermId() {
        return permissionsByPermId;
    }

    public void setPermissionsByPermId(Permissions permissionsByPermId) {
        this.permissionsByPermId = permissionsByPermId;
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
}
