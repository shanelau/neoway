package cn.neoway.cloud.model;

import cn.neoway.cloud.bean.Users;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-26
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 */
public class SimplePlanModel {
    private Integer proPlanId;
    private String moduleProId;
    private Timestamp proCreateDate;
    private String mkType;
    private Integer proceCount;
    private Users dealUser;
    private String planState;
    private Users lastUser;
    private String dealAdvice;
    private Timestamp accomplishDate;

    public Timestamp getAccomplishDate() {
        return accomplishDate;
    }

    public void setAccomplishDate(Timestamp accomplishDate) {
        this.accomplishDate = accomplishDate;
    }

    public Integer getProPlanId() {
        return proPlanId;
    }

    public void setProPlanId(Integer proPlanId) {
        this.proPlanId = proPlanId;
    }

    public String getModuleProId() {
        return moduleProId;
    }

    public void setModuleProId(String moduleProId) {
        this.moduleProId = moduleProId;
    }

    public Timestamp getProCreateDate() {
        return proCreateDate;
    }

    public void setProCreateDate(Timestamp proCreateDate) {
        this.proCreateDate = proCreateDate;
    }

    public String getMkType() {
        return mkType;
    }

    public void setMkType(String mkType) {
        this.mkType = mkType;
    }

    public Integer getProceCount() {
        return proceCount;
    }

    public void setProceCount(Integer proceCount) {
        this.proceCount = proceCount;
    }

    public Users getDealUser() {
        return dealUser;
    }

    public void setDealUser(Users dealUser) {
        this.dealUser = dealUser;
    }

    public String getPlanState() {
        return planState;
    }

    public void setPlanState(String planState) {
        this.planState = planState;
    }

    public Users getLastUser() {
        return lastUser;
    }

    public void setLastUser(Users lastUser) {
        this.lastUser = lastUser;
    }

    public String getDealAdvice() {
        return dealAdvice;
    }

    public void setDealAdvice(String dealAdvice) {
        this.dealAdvice = dealAdvice;
    }

    @Override
    public String toString() {
        return "SimplePlanModel{" +
                "proPlanId=" + proPlanId +
                ", moduleProId='" + moduleProId + '\'' +
                ", proCreateDate=" + proCreateDate +
                ", mkType='" + mkType + '\'' +
                ", proceCount=" + proceCount +
                ", dealUser=" + dealUser.getUserName() +
                ", planState='" + planState + '\'' +
                ", upUser='" + lastUser.getUserName() + '\'' +
                ", dealAdvice='" + dealAdvice + '\'' +
                '}';
    }
}
