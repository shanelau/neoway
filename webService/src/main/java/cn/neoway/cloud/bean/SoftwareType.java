package cn.neoway.cloud.bean;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "software_type", schema = "", catalog = "neoway")
@Entity
public class SoftwareType {
    private int softTypeId;

    @javax.persistence.Column(name = "soft_type_id")
    @Id
    public int getSoftTypeId() {
        return softTypeId;
    }

    public void setSoftTypeId(int softTypeId) {
        this.softTypeId = softTypeId;
    }

    private Integer softTypeName;

    @javax.persistence.Column(name = "soft_type_name")
    @Basic
    public Integer getSoftTypeName() {
        return softTypeName;
    }

    public void setSoftTypeName(Integer softTypeName) {
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

    @OneToMany(mappedBy = "softwareTypeBySoftTypeId")
    public Collection<SoftwareInfo> getSoftwareInfosBySoftTypeId() {
        return softwareInfosBySoftTypeId;
    }

    public void setSoftwareInfosBySoftTypeId(Collection<SoftwareInfo> softwareInfosBySoftTypeId) {
        this.softwareInfosBySoftTypeId = softwareInfosBySoftTypeId;
    }
}
