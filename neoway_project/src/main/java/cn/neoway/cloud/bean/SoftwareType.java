package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "software_type", schema = "", catalog = "neoway")
@Entity
public class SoftwareType extends AbstractModel {
    private int softTypeId;

    @javax.persistence.Column(name = "soft_type_id")
    @Id
    @GeneratedValue
    public int getSoftTypeId() {
        return softTypeId;
    }

    public void setSoftTypeId(int softTypeId) {
        this.softTypeId = softTypeId;
    }

    private String softTypeName;

    @javax.persistence.Column(name = "soft_type_name")
    @Basic
    public String getSoftTypeName() {
        return softTypeName;
    }

    public void setSoftTypeName(String softTypeName) {
        this.softTypeName = softTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoftwareType that = (SoftwareType) o;

        if (softTypeId != that.softTypeId) return false;
        if (softTypeName != null ? !softTypeName.equals(that.softTypeName) : that.softTypeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = softTypeId;
        result = 31 * result + (softTypeName != null ? softTypeName.hashCode() : 0);
        return result;
    }

    private Collection<SoftwareInfo> softwareInfosBySoftTypeId;

    @OneToMany(mappedBy = "softwareTypeBySoftTypeId",fetch = FetchType.EAGER)
    public Collection<SoftwareInfo> getSoftwareInfosBySoftTypeId() {
        return softwareInfosBySoftTypeId;
    }

    public void setSoftwareInfosBySoftTypeId(Collection<SoftwareInfo> softwareInfosBySoftTypeId) {
        this.softwareInfosBySoftTypeId = softwareInfosBySoftTypeId;
    }
}
