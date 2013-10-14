package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "pro_soft_list", schema = "", catalog = "neoway")
@Entity
public class ProSoftList extends AbstractModel {
    private int useSoftId;

    @javax.persistence.Column(name = "use_soft_id")
    @Id
    @GeneratedValue
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

    private Project projectByProPlanId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "pro_plan_id", referencedColumnName = "pro_plan_id", nullable = false)
    public Project getProjectByProPlanId() {
        return projectByProPlanId;
    }

    public void setProjectByProPlanId(Project proPlanId) {
        this.projectByProPlanId = proPlanId;
    }

    private SoftwareInfo softwareInfoByProSoftwareId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "pro_software_id", referencedColumnName = "pro_software_id",insertable = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public SoftwareInfo getSoftwareInfoByProSoftwareId() {
        return softwareInfoByProSoftwareId;
    }

    public void setSoftwareInfoByProSoftwareId(SoftwareInfo softwareInfoByProSoftwareId) {
        this.softwareInfoByProSoftwareId = softwareInfoByProSoftwareId;
    }
}
