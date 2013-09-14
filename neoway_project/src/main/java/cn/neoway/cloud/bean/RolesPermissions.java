package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "roles_permissions", schema = "", catalog = "neoway")
@Entity
public class RolesPermissions extends AbstractModel{
    private int rolePeriId;

    @javax.persistence.Column(name = "role_peri_id")
    @Id
    public int getRolePeriId() {
        return rolePeriId;
    }

    public void setRolePeriId(int rolePeriId) {
        this.rolePeriId = rolePeriId;
    }

    private String rolePeriDesc;

    @javax.persistence.Column(name = "role_peri_desc")
    @Basic
    public String getRolePeriDesc() {
        return rolePeriDesc;
    }

    public void setRolePeriDesc(String rolePeriDesc) {
        this.rolePeriDesc = rolePeriDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesPermissions that = (RolesPermissions) o;

        if (rolePeriId != that.rolePeriId) return false;
        if (rolePeriDesc != null ? !rolePeriDesc.equals(that.rolePeriDesc) : that.rolePeriDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolePeriId;
        result = 31 * result + (rolePeriDesc != null ? rolePeriDesc.hashCode() : 0);
        return result;
    }

    private Permissions permissionsByPeriId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "peri_id", referencedColumnName = "peri_id")
    public Permissions getPermissionsByPeriId() {
        return permissionsByPeriId;
    }

    public void setPermissionsByPeriId(Permissions permissionsByPeriId) {
        this.permissionsByPeriId = permissionsByPeriId;
    }

    private Roles rolesByRoleId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
    @Override
    public String toString(){
        return getRolesByRoleId().getRoleName()+"\t"+getRolePeriDesc()+"\t"+getPermissionsByPeriId().getPeriDesc()+"\t";
    }
}
