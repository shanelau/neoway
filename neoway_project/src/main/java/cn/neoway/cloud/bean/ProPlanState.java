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
@javax.persistence.Table(name = "pro_plan_state", schema = "", catalog = "neoway")
@Entity
public class ProPlanState {
    private int proPlanStateId;

    @javax.persistence.Column(name = "pro_plan_state_id")
    @Id
    public int getProPlanStateId() {
        return proPlanStateId;
    }

    public void setProPlanStateId(int proPlanStateId) {
        this.proPlanStateId = proPlanStateId;
    }

    private String proPlanStateName;

    @javax.persistence.Column(name = "pro_plan_state_name")
    @Basic
    public String getProPlanStateName() {
        return proPlanStateName;
    }

    public void setProPlanStateName(String proPlanStateName) {
        this.proPlanStateName = proPlanStateName;
    }

    private String proPlanStateDesc;

    @javax.persistence.Column(name = "pro_plan_state_desc")
    @Basic
    public String getProPlanStateDesc() {
        return proPlanStateDesc;
    }

    public void setProPlanStateDesc(String proPlanStateDesc) {
        this.proPlanStateDesc = proPlanStateDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProPlanState that = (ProPlanState) o;

        if (proPlanStateId != that.proPlanStateId) return false;
        if (proPlanStateDesc != null ? !proPlanStateDesc.equals(that.proPlanStateDesc) : that.proPlanStateDesc != null)
            return false;
        if (proPlanStateName != null ? !proPlanStateName.equals(that.proPlanStateName) : that.proPlanStateName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proPlanStateId;
        result = 31 * result + (proPlanStateName != null ? proPlanStateName.hashCode() : 0);
        result = 31 * result + (proPlanStateDesc != null ? proPlanStateDesc.hashCode() : 0);
        return result;
    }

    private Collection<Project> projectsByProPlanStateId;

    @OneToMany(mappedBy = "proPlanStateByProPlanStateId")
    public Collection<Project> getProjectsByProPlanStateId() {
        return projectsByProPlanStateId;
    }

    public void setProjectsByProPlanStateId(Collection<Project> projectsByProPlanStateId) {
        this.projectsByProPlanStateId = projectsByProPlanStateId;
    }
}
