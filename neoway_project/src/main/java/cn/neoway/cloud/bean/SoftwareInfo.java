package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "software_info", schema = "", catalog = "neoway")
@Entity
public class SoftwareInfo extends AbstractModel {
    private int proSoftwareId;

    @javax.persistence.Column(name = "pro_software_id")
    @Id
    @GeneratedValue
    public int getProSoftwareId() {
        return proSoftwareId;
    }

    public void setProSoftwareId(int proSoftwareId) {
        this.proSoftwareId = proSoftwareId;
    }

    private String softName;

    @javax.persistence.Column(name = "soft_name")
    @Basic
    public String getSoftName() {
        return softName;
    }

    public void setSoftName(String softName) {
        this.softName = softName;
    }

    private String variasoftEdition;

    @javax.persistence.Column(name = "Variasoft_edition")
    @Basic
    public String getVariasoftEdition() {
        return variasoftEdition;
    }

    public void setVariasoftEdition(String variasoftEdition) {
        this.variasoftEdition = variasoftEdition;
    }

    private String softwarePath;

    @javax.persistence.Column(name = "software_path")
    @Basic
    public String getSoftwarePath() {
        return softwarePath;
    }

    public void setSoftwarePath(String softwarePath) {
        this.softwarePath = softwarePath;
    }

    private Timestamp date;

    @javax.persistence.Column(name = "Date")
    @Basic
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    private String softRemark;

    @javax.persistence.Column(name = "soft_remark")
    @Basic
    public String getSoftRemark() {
        return softRemark;
    }

    public void setSoftRemark(String softRemark) {
        this.softRemark = softRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoftwareInfo that = (SoftwareInfo) o;

        if (proSoftwareId != that.proSoftwareId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (softName != null ? !softName.equals(that.softName) : that.softName != null) return false;
        if (softRemark != null ? !softRemark.equals(that.softRemark) : that.softRemark != null) return false;
        if (softwarePath != null ? !softwarePath.equals(that.softwarePath) : that.softwarePath != null) return false;
        if (variasoftEdition != null ? !variasoftEdition.equals(that.variasoftEdition) : that.variasoftEdition != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proSoftwareId;
        result = 31 * result + (softName != null ? softName.hashCode() : 0);
        result = 31 * result + (variasoftEdition != null ? variasoftEdition.hashCode() : 0);
        result = 31 * result + (softwarePath != null ? softwarePath.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (softRemark != null ? softRemark.hashCode() : 0);
        return result;
    }

    private Collection<ProSoftList> proSoftListsByProSoftwareId;

    @OneToMany(mappedBy = "softwareInfoByProSoftwareId")
    public Collection<ProSoftList> getProSoftListsByProSoftwareId() {
        return proSoftListsByProSoftwareId;
    }

    public void setProSoftListsByProSoftwareId(Collection<ProSoftList> proSoftListsByProSoftwareId) {
        this.proSoftListsByProSoftwareId = proSoftListsByProSoftwareId;
    }

    private SoftwareType softwareTypeBySoftTypeId;

    @ManyToOne
    @JoinColumn(name = "soft_type_id", referencedColumnName = "soft_type_id",insertable = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public SoftwareType getSoftwareTypeBySoftTypeId() {
        return softwareTypeBySoftTypeId;
    }

    public void setSoftwareTypeBySoftTypeId(SoftwareType softwareTypeBySoftTypeId) {
        this.softwareTypeBySoftTypeId = softwareTypeBySoftTypeId;
    }
}
