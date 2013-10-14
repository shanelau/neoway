package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "permissions", schema = "", catalog = "neoway")
@Entity
public class Permissions extends AbstractModel {
    private int periId;

    @javax.persistence.Column(name = "peri_id")
    @Id
    public int getPeriId() {
        return periId;
    }

    public void setPeriId(int periId) {
        this.periId = periId;
    }

    private String periName;

    @javax.persistence.Column(name = "peri_name")
    @Basic
    public String getPeriName() {
        return periName;
    }

    public void setPeriName(String periName) {
        this.periName = periName;
    }

    private String periDesc;

    @javax.persistence.Column(name = "peri_desc")
    @Basic
    public String getPeriDesc() {
        return periDesc;
    }

    public void setPeriDesc(String periDesc) {
        this.periDesc = periDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permissions that = (Permissions) o;

        if (periId != that.periId) return false;
        if (periDesc != null ? !periDesc.equals(that.periDesc) : that.periDesc != null) return false;
        if (periName != null ? !periName.equals(that.periName) : that.periName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = periId;
        result = 31 * result + (periName != null ? periName.hashCode() : 0);
        result = 31 * result + (periDesc != null ? periDesc.hashCode() : 0);
        return result;
    }

    private Collection<RolesPermissions> rolesPermissionsesByPeriId;

    @OneToMany(mappedBy = "permissionsByPeriId")
    public Collection<RolesPermissions> getRolesPermissionsesByPeriId() {
        return rolesPermissionsesByPeriId;
    }

    public void setRolesPermissionsesByPeriId(Collection<RolesPermissions> rolesPermissionsesByPeriId) {
        this.rolesPermissionsesByPeriId = rolesPermissionsesByPeriId;
    }
}
