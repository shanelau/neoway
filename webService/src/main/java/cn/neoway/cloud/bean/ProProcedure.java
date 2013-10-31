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
@javax.persistence.Table(name = "pro_procedure", schema = "", catalog = "neoway")
@Entity
public class ProProcedure {
    private int proceId;

    @javax.persistence.Column(name = "proce_id")
    @Id
    public int getProceId() {
        return proceId;
    }

    public void setProceId(int proceId) {
        this.proceId = proceId;
    }

    private Boolean isSmt;

    @javax.persistence.Column(name = "is_smt")
    @Basic
    public Boolean getSmt() {
        return isSmt;
    }

    public void setSmt(Boolean smt) {
        isSmt = smt;
    }

    private Boolean isUpdate;

    @javax.persistence.Column(name = "is_update")
    @Basic
    public Boolean getUpdate() {
        return isUpdate;
    }

    public void setUpdate(Boolean update) {
        isUpdate = update;
    }

    private Boolean isPack;

    @javax.persistence.Column(name = "is_pack")
    @Basic
    public Boolean getPack() {
        return isPack;
    }

    public void setPack(Boolean pack) {
        isPack = pack;
    }

    private Boolean isTest;

    @javax.persistence.Column(name = "is_test")
    @Basic
    public Boolean getTest() {
        return isTest;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    private Boolean isWrap;

    @javax.persistence.Column(name = "is_wrap")
    @Basic
    public Boolean getWrap() {
        return isWrap;
    }

    public void setWrap(Boolean wrap) {
        isWrap = wrap;
    }

    private Boolean isOther;

    @javax.persistence.Column(name = "is_other")
    @Basic
    public Boolean getOther() {
        return isOther;
    }

    public void setOther(Boolean other) {
        isOther = other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProProcedure that = (ProProcedure) o;

        if (proceId != that.proceId) return false;
        if (isOther != null ? !isOther.equals(that.isOther) : that.isOther != null) return false;
        if (isPack != null ? !isPack.equals(that.isPack) : that.isPack != null) return false;
        if (isSmt != null ? !isSmt.equals(that.isSmt) : that.isSmt != null) return false;
        if (isTest != null ? !isTest.equals(that.isTest) : that.isTest != null) return false;
        if (isUpdate != null ? !isUpdate.equals(that.isUpdate) : that.isUpdate != null) return false;
        if (isWrap != null ? !isWrap.equals(that.isWrap) : that.isWrap != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proceId;
        result = 31 * result + (isSmt != null ? isSmt.hashCode() : 0);
        result = 31 * result + (isUpdate != null ? isUpdate.hashCode() : 0);
        result = 31 * result + (isPack != null ? isPack.hashCode() : 0);
        result = 31 * result + (isTest != null ? isTest.hashCode() : 0);
        result = 31 * result + (isWrap != null ? isWrap.hashCode() : 0);
        result = 31 * result + (isOther != null ? isOther.hashCode() : 0);
        return result;
    }

    private Collection<ManuInfo> manuInfosByProceId;

    @OneToMany(mappedBy = "proProcedureByProceId")
    public Collection<ManuInfo> getManuInfosByProceId() {
        return manuInfosByProceId;
    }

    public void setManuInfosByProceId(Collection<ManuInfo> manuInfosByProceId) {
        this.manuInfosByProceId = manuInfosByProceId;
    }
}
