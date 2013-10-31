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
@javax.persistence.Table(name = "plan_user", schema = "", catalog = "neoway")
@Entity
public class PlanUser {
    private int planUserListId1;

    @javax.persistence.Column(name = "plan_user_list_id1")
    @Id
    public int getPlanUserListId1() {
        return planUserListId1;
    }

    public void setPlanUserListId1(int planUserListId1) {
        this.planUserListId1 = planUserListId1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanUser planUser = (PlanUser) o;

        if (planUserListId1 != planUser.planUserListId1) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return planUserListId1;
    }

    private Project projectByProPlanId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "pro_plan_id", referencedColumnName = "pro_plan_id")
    public Project getProjectByProPlanId() {
        return projectByProPlanId;
    }

    public void setProjectByProPlanId(Project projectByProPlanId) {
        this.projectByProPlanId = projectByProPlanId;
    }

    private PlanUserType planUserTypeByPlanUserTypeId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "plan_user_type_id", referencedColumnName = "plan_user_type_id")
    public PlanUserType getPlanUserTypeByPlanUserTypeId() {
        return planUserTypeByPlanUserTypeId;
    }

    public void setPlanUserTypeByPlanUserTypeId(PlanUserType planUserTypeByPlanUserTypeId) {
        this.planUserTypeByPlanUserTypeId = planUserTypeByPlanUserTypeId;
    }

    private Users usersByUserId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
