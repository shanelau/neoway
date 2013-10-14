package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "plan_user", schema = "", catalog = "neoway")
@Entity
public class PlanUser extends AbstractModel {
    private int planUserListId1;

    @javax.persistence.Column(name = "plan_user_list_id1")
    @Id
    public int getPlanUserListId1() {
        return planUserListId1;
    }

    public void setPlanUserListId1(int planUserListId1) {
        this.planUserListId1 = planUserListId1;
    }

    private Boolean isPass;

    @javax.persistence.Column(name = "is_pass")
    @Basic
    public Boolean getPass() {
        return isPass;
    }

    public void setPass(Boolean pass) {
        isPass = pass;
    }

    private String dealAdvice;

    @javax.persistence.Column(name = "deal_advice")
    @Basic
    public String getDealAdvice() {
        return dealAdvice;
    }

    public void setDealAdvice(String dealAdvice) {
        this.dealAdvice = dealAdvice;
    }

    private String dealUser;

    @javax.persistence.Column(name = "deal_user")
    @Basic
    public String getDealUser() {
        return dealUser;
    }

    public void setDealUser(String dealUser) {
        this.dealUser = dealUser;
    }

    private Timestamp dealTime;

    @javax.persistence.Column(name = "deal_time")
    @Basic
    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanUser planUser = (PlanUser) o;

        if (planUserListId1 != planUser.planUserListId1) return false;
        if (dealAdvice != null ? !dealAdvice.equals(planUser.dealAdvice) : planUser.dealAdvice != null) return false;
        if (dealTime != null ? !dealTime.equals(planUser.dealTime) : planUser.dealTime != null) return false;
        if (dealUser != null ? !dealUser.equals(planUser.dealUser) : planUser.dealUser != null) return false;
        if (isPass != null ? !isPass.equals(planUser.isPass) : planUser.isPass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planUserListId1;
        result = 31 * result + (isPass != null ? isPass.hashCode() : 0);
        result = 31 * result + (dealAdvice != null ? dealAdvice.hashCode() : 0);
        result = 31 * result + (dealUser != null ? dealUser.hashCode() : 0);
        result = 31 * result + (dealTime != null ? dealTime.hashCode() : 0);
        return result;
    }

    private Project projectByProPlanId;

    @ManyToOne()
    @javax.persistence.JoinColumn(name = "pro_plan_id", referencedColumnName = "pro_plan_id")
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
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
