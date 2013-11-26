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
@Entity
public class Permissions extends AbstractModel {
    private int permId;

    @javax.persistence.Column(name = "perm_Id")
    @Id
    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }

    private String permName;

    @javax.persistence.Column(name = "perm_Name")
    @Basic
    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    private String permDesc;

    @javax.persistence.Column(name = "perm_Desc")
    @Basic
    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permissions that = (Permissions) o;

        if (permId != that.permId) return false;
        if (permDesc != null ? !permDesc.equals(that.permDesc) : that.permDesc != null) return false;
        if (permName != null ? !permName.equals(that.permName) : that.permName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permId;
        result = 31 * result + (permName != null ? permName.hashCode() : 0);
        result = 31 * result + (permDesc != null ? permDesc.hashCode() : 0);
        return result;
    }

    private Collection<RolesPermissions> rolesPermissionsesByPermId;

    @OneToMany(mappedBy = "permissionsByPermId")
    public Collection<RolesPermissions> getRolesPermissionsesByPermId() {
        return rolesPermissionsesByPermId;
    }

    public void setRolesPermissionsesByPermId(Collection<RolesPermissions> rolesPermissionsesByPermId) {
        this.rolesPermissionsesByPermId = rolesPermissionsesByPermId;
    }
}
