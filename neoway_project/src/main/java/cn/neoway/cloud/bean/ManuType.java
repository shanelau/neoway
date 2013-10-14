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
@javax.persistence.Table(name = "manu_type", schema = "", catalog = "neoway")
@Entity
public class ManuType extends AbstractModel {
    private int manuTypeId;

    @javax.persistence.Column(name = "manu_type_id")
    @Id
    public int getManuTypeId() {
        return manuTypeId;
    }

    public void setManuTypeId(int manuTypeId) {
        this.manuTypeId = manuTypeId;
    }

    private String manuTypeName;

    @javax.persistence.Column(name = "manu_type_name")
    @Basic
    public String getManuTypeName() {
        return manuTypeName;
    }

    public void setManuTypeName(String manuTypeName) {
        this.manuTypeName = manuTypeName;
    }

    private String manuTypeDesc;

    @javax.persistence.Column(name = "manu_type_desc")
    @Basic
    public String getManuTypeDesc() {
        return manuTypeDesc;
    }

    public void setManuTypeDesc(String manuTypeDesc) {
        this.manuTypeDesc = manuTypeDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManuType manuType = (ManuType) o;

        if (manuTypeId != manuType.manuTypeId) return false;
        if (manuTypeDesc != null ? !manuTypeDesc.equals(manuType.manuTypeDesc) : manuType.manuTypeDesc != null)
            return false;
        if (manuTypeName != null ? !manuTypeName.equals(manuType.manuTypeName) : manuType.manuTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manuTypeId;
        result = 31 * result + (manuTypeName != null ? manuTypeName.hashCode() : 0);
        result = 31 * result + (manuTypeDesc != null ? manuTypeDesc.hashCode() : 0);
        return result;
    }

    private Collection<ManuLog> manuLogsByManuTypeId;

    @OneToMany(mappedBy = "manuTypeByManuTypeId")
    public Collection<ManuLog> getManuLogsByManuTypeId() {
        return manuLogsByManuTypeId;
    }

    public void setManuLogsByManuTypeId(Collection<ManuLog> manuLogsByManuTypeId) {
        this.manuLogsByManuTypeId = manuLogsByManuTypeId;
    }
}
