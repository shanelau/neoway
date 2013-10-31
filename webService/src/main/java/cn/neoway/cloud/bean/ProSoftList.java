package cn.neoway.cloud.bean;

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
@javax.persistence.Table(name = "pro_soft_list", schema = "", catalog = "neoway")
@Entity
public class ProSoftList {
    private int useSoftId;

    @javax.persistence.Column(name = "use_soft_id")
    @Id
    public int getUseSoftId() {
        return useSoftId;
    }

    public void setUseSoftId(int useSoftId) {
        this.useSoftId = useSoftId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProSoftList that = (ProSoftList) o;

        if (useSoftId != that.useSoftId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return useSoftId;
    }

    private ManuInfo manuInfoByManuInfoId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "manu_info_id", referencedColumnName = "manu_info_id", nullable = false)
    public ManuInfo getManuInfoByManuInfoId() {
        return manuInfoByManuInfoId;
    }

    public void setManuInfoByManuInfoId(ManuInfo manuInfoByManuInfoId) {
        this.manuInfoByManuInfoId = manuInfoByManuInfoId;
    }

    private SoftwareInfo softwareInfoByProSoftwareId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "pro_software_id", referencedColumnName = "pro_software_id")
    public SoftwareInfo getSoftwareInfoByProSoftwareId() {
        return softwareInfoByProSoftwareId;
    }

    public void setSoftwareInfoByProSoftwareId(SoftwareInfo softwareInfoByProSoftwareId) {
        this.softwareInfoByProSoftwareId = softwareInfoByProSoftwareId;
    }
}
