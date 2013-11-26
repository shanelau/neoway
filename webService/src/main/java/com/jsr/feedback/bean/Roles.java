package com.jsr.feedback.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-19
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "roles", schema = "", catalog = "jsr_rom_db")
@Entity
public class Roles extends AbstractModel{
    private int roleId;

    @javax.persistence.Column(name = "role_Id")
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    private String roleName;

    @javax.persistence.Column(name = "role_Name")
    @Basic
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String roleDesc;

    @javax.persistence.Column(name = "role_Desc")
    @Basic
    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        if (roleId != roles.roleId) return false;
        if (roleDesc != null ? !roleDesc.equals(roles.roleDesc) : roles.roleDesc != null) return false;
        if (roleName != null ? !roleName.equals(roles.roleName) : roles.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleDesc != null ? roleDesc.hashCode() : 0);
        return result;
    }

    private Collection<RolesPermissions> rolesPermissionsesByRoleId;

    @OneToMany(mappedBy = "rolesByRoleId")
    public Collection<RolesPermissions> getRolesPermissionsesByRoleId() {
        return rolesPermissionsesByRoleId;
    }

    public void setRolesPermissionsesByRoleId(Collection<RolesPermissions> rolesPermissionsesByRoleId) {
        this.rolesPermissionsesByRoleId = rolesPermissionsesByRoleId;
    }

    private Collection<UsersRoles> usersRolesesByRoleId;

    @OneToMany(mappedBy = "rolesByRoleId")
    public Collection<UsersRoles> getUsersRolesesByRoleId() {
        return usersRolesesByRoleId;
    }

    public void setUsersRolesesByRoleId(Collection<UsersRoles> usersRolesesByRoleId) {
        this.usersRolesesByRoleId = usersRolesesByRoleId;
    }
}
