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
@javax.persistence.Table(name = "plan_user_type", schema = "", catalog = "neoway")
@Entity
public class PlanUserType extends AbstractModel {
    private int planUserTypeId;

    @javax.persistence.Column(name = "plan_user_type_id")
    @Id
    public int getPlanUserTypeId() {
        return planUserTypeId;
    }

    public void setPlanUserTypeId(int planUserTypeId) {
        this.planUserTypeId = planUserTypeId;
    }

    private String planUserTypeName;

    @javax.persistence.Column(name = "plan_user_type_name")
    @Basic
    public String getPlanUserTypeName() {
        return planUserTypeName;
    }

    public void setPlanUserTypeName(String planUserTypeName) {
        this.planUserTypeName = planUserTypeName;
    }

    private String planUserDesc;

    @javax.persistence.Column(name = "plan_user_desc")
    @Basic
    public String getPlanUserDesc() {
        return planUserDesc;
    }

    public void setPlanUserDesc(String planUserDesc) {
        this.planUserDesc = planUserDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanUserType that = (PlanUserType) o;

        if (planUserTypeId != that.planUserTypeId) return false;
        if (planUserDesc != null ? !planUserDesc.equals(that.planUserDesc) : that.planUserDesc != null) return false;
        if (planUserTypeName != null ? !planUserTypeName.equals(that.planUserTypeName) : that.planUserTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planUserTypeId;
        result = 31 * result + (planUserTypeName != null ? planUserTypeName.hashCode() : 0);
        result = 31 * result + (planUserDesc != null ? planUserDesc.hashCode() : 0);
        return result;
    }

    private Collection<PlanUser> planUsersByPlanUserTypeId;

    @OneToMany(mappedBy = "planUserTypeByPlanUserTypeId")
    public Collection<PlanUser> getPlanUsersByPlanUserTypeId() {
        return planUsersByPlanUserTypeId;
    }

    public void setPlanUsersByPlanUserTypeId(Collection<PlanUser> planUsersByPlanUserTypeId) {
        this.planUsersByPlanUserTypeId = planUsersByPlanUserTypeId;
    }
    @Override
    public String toString(){
        return   planUserTypeId+"\t"+  planUserTypeName+"\t"+   planUserDesc;
    }
}
