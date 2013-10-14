package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "project", schema = "", catalog = "neoway")
@Entity
public class Project extends AbstractModel{
    private int proPlanId;

    @javax.persistence.Column(name = "pro_plan_id")
    @Id
    @GeneratedValue
    public int getProPlanId() {
        return proPlanId;
    }

    public void setProPlanId(int proPlanId) {
        this.proPlanId = proPlanId;
    }

    private String moduleProId;

    @javax.persistence.Column(name = "module_pro_id")
    @Basic
    public String getModuleProId() {
        return moduleProId;
    }

    public void setModuleProId(String moduleProId) {
        this.moduleProId = moduleProId;
    }

    private String proSource;

    @javax.persistence.Column(name = "pro_source")
    @Basic
    public String getProSource() {
        return proSource;
    }

    public void setProSource(String proSource) {
        this.proSource = proSource;
    }

    private String proceManu;

    @javax.persistence.Column(name = "proce_manu")
    @Basic
    public String getProceManu() {
        return proceManu;
    }

    public void setProceManu(String proceManu) {
        this.proceManu = proceManu;
    }

    private String mkType;

    @javax.persistence.Column(name = "mk_type")
    @Basic
    public String getMkType() {
        return mkType;
    }

    public void setMkType(String mkType) {
        this.mkType = mkType;
    }

    private Integer proceCount;

    @javax.persistence.Column(name = "proce_count")
    @Basic
    public Integer getProceCount() {
        return proceCount;
    }

    public void setProceCount(Integer proceCount) {
        this.proceCount = proceCount;
    }

    private Timestamp accomplishDate;

    @javax.persistence.Column(name = "accomplish_date")
    @Basic
    public Timestamp getAccomplishDate() {
        return accomplishDate;
    }

    public void setAccomplishDate(Timestamp accomplishDate) {
        this.accomplishDate = accomplishDate;
    }



    private String REVVversion;
    @javax.persistence.Column(name = "REV_Version")
    @Basic
    public String getREVVversion() {
        return REVVversion;
    }

    public void setREVVversion(String REVVversion) {
        this.REVVversion = REVVversion;
    }
    private String packProCode;
    @javax.persistence.Column(name = "pack_pro_code")
    @Basic
    public String getPackProCode() {
        return packProCode;
    }

    public void setPackProCode(String packProCode) {
        this.packProCode = packProCode;
    }



    private String packProName;

    @javax.persistence.Column(name = "pack_pro_name")
    @Basic
    public String getPackProName() {
        return packProName;
    }

    public void setPackProName(String packProName) {
        this.packProName = packProName;
    }

    private String packResource;

    @javax.persistence.Column(name = "pack_resource")
    @Basic
    public String getPackResource() {
        return packResource;
    }

    public void setPackResource(String packResource) {
        this.packResource = packResource;
    }

    private String packSoftwareNo;

    @javax.persistence.Column(name = "pack_software_no")
    @Basic
    public String getPackSoftwareNo() {
        return packSoftwareNo;
    }

    public void setPackSoftwareNo(String packSoftwareNo) {
        this.packSoftwareNo = packSoftwareNo;
    }

    private String packPeiliao;

    @javax.persistence.Column(name = "pack_peiliao")
    @Basic
    public String getPackPeiliao() {
        return packPeiliao;
    }

    public void setPackPeiliao(String packPeiliao) {
        this.packPeiliao = packPeiliao;
    }

    private String packCaihe;

    @javax.persistence.Column(name = "pack_caihe")
    @Basic
    public String getPackCaihe() {
        return packCaihe;
    }

    public void setPackCaihe(String packCaihe) {
        this.packCaihe = packCaihe;
    }

    private String packDakat;

    @javax.persistence.Column(name = "pack_dakat")
    @Basic
    public String getPackDakat() {
        return packDakat;
    }

    public void setPackDakat(String packDakat) {
        this.packDakat = packDakat;
    }

    private String packIsBiaotie;

    @javax.persistence.Column(name = "pack_is_biaotie")
    @Basic
    public String getPackIsBiaotie() {
        return packIsBiaotie;
    }

    public void setPackIsBiaotie(String packIsBiaotie) {
        this.packIsBiaotie = packIsBiaotie;
    }

    private Boolean packUpdateRate;

    @javax.persistence.Column(name = "pack_update_rate")
    @Basic
    public Boolean getPackUpdateRate() {
        return packUpdateRate;
    }

    public void setPackUpdateRate(Boolean packUpdateRate) {
        this.packUpdateRate = packUpdateRate;
    }

    private String packBaudRate;

    @javax.persistence.Column(name = "pack_baud_rate")
    @Basic
    public String getPackBaudRate() {
        return packBaudRate;
    }

    public void setPackBaudRate(String packBaudRate) {
        this.packBaudRate = packBaudRate;
    }

    private Boolean packIsCheck;

    @javax.persistence.Column(name = "pack_is_check")
    @Basic
    public Boolean getPackIsCheck() {
        return packIsCheck;
    }

    public void setPackIsCheck(Boolean packIsCheck) {
        this.packIsCheck = packIsCheck;
    }

    private String packImeiStart;

    @javax.persistence.Column(name = "pack_imei_start")
    @Basic
    public String getPackImeiStart() {
        return packImeiStart;
    }

    public void setPackImeiStart(String packImeiStart) {
        this.packImeiStart = packImeiStart;
    }

    private String packImeiEnd;

    @javax.persistence.Column(name = "pack_imei_end")
    @Basic
    public String getPackImeiEnd() {
        return packImeiEnd;
    }

    public void setPackImeiEnd(String packImeiEnd) {
        this.packImeiEnd = packImeiEnd;
    }

    private String packBiaotieNo;

    @javax.persistence.Column(name = "pack_biaotie_no")
    @Basic
    public String getPackBiaotieNo() {
        return packBiaotieNo;
    }

    public void setPackBiaotieNo(String packBiaotieNo) {
        this.packBiaotieNo = packBiaotieNo;
    }

    private String packTangdaiNo;

    @javax.persistence.Column(name = "pack_tangdai_no")
    @Basic
    public String getPackTangdaiNo() {
        return packTangdaiNo;
    }

    public void setPackTangdaiNo(String packTangdaiNo) {
        this.packTangdaiNo = packTangdaiNo;
    }

    private Timestamp proCreateDate;

    @javax.persistence.Column(name = "pro_create_date")
    @Basic
    public Timestamp getProCreateDate() {
        return proCreateDate;
    }

    public void setProCreateDate(Timestamp proCreateDate) {
        this.proCreateDate = proCreateDate;
    }

    private Timestamp proPassDate;

    @javax.persistence.Column(name = "pro_pass_date")
    @Basic
    public Timestamp getProPassDate() {
        return proPassDate;
    }

    public void setProPassDate(Timestamp proPassDate) {
        this.proPassDate = proPassDate;
    }

    private String proSnStart;

    @javax.persistence.Column(name = "pro_sn_start")
    @Basic
    public String getProSnStart() {
        return proSnStart;
    }

    public void setProSnStart(String proSnStart) {
        this.proSnStart = proSnStart;
    }

    private String proSnEnd;

    @javax.persistence.Column(name = "pro_sn_end")
    @Basic
    public String getProSnEnd() {
        return proSnEnd;
    }

    public void setProSnEnd(String proSnEnd) {
        this.proSnEnd = proSnEnd;
    }

    private String sendEmail;

    @javax.persistence.Column(name = "send_email")
    @Basic
    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (proPlanId != project.proPlanId) return false;
        if (accomplishDate != null ? !accomplishDate.equals(project.accomplishDate) : project.accomplishDate != null)
            return false;
        if (mkType != null ? !mkType.equals(project.mkType) : project.mkType != null) return false;
        if (moduleProId != null ? !moduleProId.equals(project.moduleProId) : project.moduleProId != null) return false;
        if (packBaudRate != null ? !packBaudRate.equals(project.packBaudRate) : project.packBaudRate != null)
            return false;
        if (packBiaotieNo != null ? !packBiaotieNo.equals(project.packBiaotieNo) : project.packBiaotieNo != null)
            return false;
        if (packCaihe != null ? !packCaihe.equals(project.packCaihe) : project.packCaihe != null) return false;
        if (packDakat != null ? !packDakat.equals(project.packDakat) : project.packDakat != null) return false;
        if (packImeiEnd != null ? !packImeiEnd.equals(project.packImeiEnd) : project.packImeiEnd != null) return false;
        if (packImeiStart != null ? !packImeiStart.equals(project.packImeiStart) : project.packImeiStart != null)
            return false;
        if (packIsBiaotie != null ? !packIsBiaotie.equals(project.packIsBiaotie) : project.packIsBiaotie != null)
            return false;
        if (packIsCheck != null ? !packIsCheck.equals(project.packIsCheck) : project.packIsCheck != null) return false;
        if (packPeiliao != null ? !packPeiliao.equals(project.packPeiliao) : project.packPeiliao != null) return false;
        if (packProCode != null ? !packProCode.equals(project.packProCode) : project.packProCode != null) return false;
        if (packProName != null ? !packProName.equals(project.packProName) : project.packProName != null) return false;
        if (packResource != null ? !packResource.equals(project.packResource) : project.packResource != null)
            return false;
        if (packSoftwareNo != null ? !packSoftwareNo.equals(project.packSoftwareNo) : project.packSoftwareNo != null)
            return false;
        if (packTangdaiNo != null ? !packTangdaiNo.equals(project.packTangdaiNo) : project.packTangdaiNo != null)
            return false;
        if (packUpdateRate != null ? !packUpdateRate.equals(project.packUpdateRate) : project.packUpdateRate != null)
            return false;
        if (proCreateDate != null ? !proCreateDate.equals(project.proCreateDate) : project.proCreateDate != null)
            return false;
        if (proPassDate != null ? !proPassDate.equals(project.proPassDate) : project.proPassDate != null) return false;
        if (proSnEnd != null ? !proSnEnd.equals(project.proSnEnd) : project.proSnEnd != null) return false;
        if (proSnStart != null ? !proSnStart.equals(project.proSnStart) : project.proSnStart != null) return false;
        if (proSource != null ? !proSource.equals(project.proSource) : project.proSource != null) return false;
        if (proceCount != null ? !proceCount.equals(project.proceCount) : project.proceCount != null) return false;
        if (proceManu != null ? !proceManu.equals(project.proceManu) : project.proceManu != null) return false;
        if (sendEmail != null ? !sendEmail.equals(project.sendEmail) : project.sendEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proPlanId;
        result = 31 * result + (moduleProId != null ? moduleProId.hashCode() : 0);
        result = 31 * result + (proSource != null ? proSource.hashCode() : 0);
        result = 31 * result + (proceManu != null ? proceManu.hashCode() : 0);
        result = 31 * result + (mkType != null ? mkType.hashCode() : 0);
        result = 31 * result + (proceCount != null ? proceCount.hashCode() : 0);
        result = 31 * result + (accomplishDate != null ? accomplishDate.hashCode() : 0);
        result = 31 * result + (packProCode != null ? packProCode.hashCode() : 0);
        result = 31 * result + (packProName != null ? packProName.hashCode() : 0);
        result = 31 * result + (packResource != null ? packResource.hashCode() : 0);
        result = 31 * result + (packSoftwareNo != null ? packSoftwareNo.hashCode() : 0);
        result = 31 * result + (packPeiliao != null ? packPeiliao.hashCode() : 0);
        result = 31 * result + (packCaihe != null ? packCaihe.hashCode() : 0);
        result = 31 * result + (packDakat != null ? packDakat.hashCode() : 0);
        result = 31 * result + (packIsBiaotie != null ? packIsBiaotie.hashCode() : 0);
        result = 31 * result + (packUpdateRate != null ? packUpdateRate.hashCode() : 0);
        result = 31 * result + (packBaudRate != null ? packBaudRate.hashCode() : 0);
        result = 31 * result + (packIsCheck != null ? packIsCheck.hashCode() : 0);
        result = 31 * result + (packImeiStart != null ? packImeiStart.hashCode() : 0);
        result = 31 * result + (packImeiEnd != null ? packImeiEnd.hashCode() : 0);
        result = 31 * result + (packBiaotieNo != null ? packBiaotieNo.hashCode() : 0);
        result = 31 * result + (packTangdaiNo != null ? packTangdaiNo.hashCode() : 0);
        result = 31 * result + (proCreateDate != null ? proCreateDate.hashCode() : 0);
        result = 31 * result + (proPassDate != null ? proPassDate.hashCode() : 0);
        result = 31 * result + (proSnStart != null ? proSnStart.hashCode() : 0);
        result = 31 * result + (proSnEnd != null ? proSnEnd.hashCode() : 0);
        result = 31 * result + (sendEmail != null ? sendEmail.hashCode() : 0);
        return result;
    }

    private Collection<PlanUser> planUsersByProPlanId;

    @OneToMany(mappedBy = "projectByProPlanId",orphanRemoval=true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public Collection<PlanUser> getPlanUsersByProPlanId() {
        return planUsersByProPlanId;
    }

    public void setPlanUsersByProPlanId(Collection<PlanUser> planUsersByProPlanId) {
        this.planUsersByProPlanId = planUsersByProPlanId;
    }

    private ProStateType proStateTypeByProPlanStateId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pro_plan_state_id", referencedColumnName = "pro_plan_state_id")
    public ProStateType getProStateTypeByProPlanStateId() {
        return proStateTypeByProPlanStateId;
    }

    public void setProStateTypeByProPlanStateId(ProStateType proStateTypeByProPlanStateId) {
        this.proStateTypeByProPlanStateId = proStateTypeByProPlanStateId;
    }

    private ConfInfo confInfoByConfFileId;

    @OneToOne
    @JoinColumn(name = "conf_file_id", referencedColumnName = "conf_file_id",insertable = true,updatable = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public ConfInfo getConfInfoByConfFileId() {
        return confInfoByConfFileId;
    }

    public void setConfInfoByConfFileId(ConfInfo confInfoByConfFileId) {
        this.confInfoByConfFileId = confInfoByConfFileId;
    }

    private SmtTiepianInfo smtTiepianInfoBySmtId;

    @OneToOne
    @JoinColumn(name = "smt_id", referencedColumnName = "smt_id",insertable = true,updatable = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public SmtTiepianInfo getSmtTiepianInfoBySmtId() {
        return smtTiepianInfoBySmtId;
    }

    public void setSmtTiepianInfoBySmtId(SmtTiepianInfo smtTiepianInfoBySmtId) {
        this.smtTiepianInfoBySmtId = smtTiepianInfoBySmtId;
    }

    private ManuInfo manuInfoByManuInfoId;

    @ManyToOne
    @JoinColumn(name = "manu_info_id", referencedColumnName = "manu_info_id",insertable = true,updatable = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public ManuInfo getManuInfoByManuInfoId() {
        return manuInfoByManuInfoId;
    }

    public void setManuInfoByManuInfoId(ManuInfo manuInfoByManuInfoId) {
        this.manuInfoByManuInfoId = manuInfoByManuInfoId;
    }
    private Collection<ProSoftList> proSoftListsByProjectId;

    @OneToMany(mappedBy = "projectByProPlanId",fetch = FetchType.EAGER,orphanRemoval=true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public Collection<ProSoftList> getProSoftListsByProjectId() {
        return proSoftListsByProjectId;
    }

    public void setProSoftListsByProjectId(Collection<ProSoftList> proSoftListsByProjectId) {
        this.proSoftListsByProjectId = proSoftListsByProjectId;
    }
}
