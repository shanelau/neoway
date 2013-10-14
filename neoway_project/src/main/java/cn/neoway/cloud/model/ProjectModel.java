package cn.neoway.cloud.model;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;
/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-23
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class ProjectModel {
    private Integer proPlanId;
    private String moduleProId;
    private String proSource;
    private String proceManu;
    private String mkType;
    private Integer proceCount;
    private Timestamp accomplishDate;
    private String revVersion;
    private String packProCode;
    private String packProName;
    private String packResource;
    private String packSoftwareNo;
    private String packPeiliao;
    private String packCaihe;
    private String packDakat;
    private String packIsBiaotie;
    private Boolean packUpdateRate;
    private String packBaudRate;
    private Boolean packIsCheck;
    private String packImeiStart;
    private String packImeiEnd;
    private String packBiaotieNo;
    private String packTangdaiNo;
    private String proSnStart;
    private String proSnEnd;
    private String sendEmail;
    private String proCreateUser;
    private String confUser;
    private String proTechUser;
    private String softManUser;
    private String proManUser;

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

    public String getProSource() {
        return proSource;
    }

    public void setProSource(String proSource) {
        this.proSource = proSource;
    }

    public String getProceManu() {
        return proceManu;
    }

    public void setProceManu(String proceManu) {
        this.proceManu = proceManu;
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
    public Timestamp getAccomplishDate() {
        return accomplishDate;
    }

    public void setAccomplishDate(Timestamp accomplishDate) {
        this.accomplishDate = accomplishDate;
    }

    public String getRevVersion() {
        return revVersion;
    }

    public void setRevVersion(String revVersion) {
        this.revVersion = revVersion;
    }

    public String getPackProCode() {
        return packProCode;
    }

    public void setPackProCode(String packProCode) {
        this.packProCode = packProCode;
    }

    public String getPackProName() {
        return packProName;
    }

    public void setPackProName(String packProName) {
        this.packProName = packProName;
    }

    public String getPackResource() {
        return packResource;
    }

    public void setPackResource(String packResource) {
        this.packResource = packResource;
    }

    public String getPackSoftwareNo() {
        return packSoftwareNo;
    }

    public void setPackSoftwareNo(String packSoftwareNo) {
        this.packSoftwareNo = packSoftwareNo;
    }

    public String getPackPeiliao() {
        return packPeiliao;
    }

    public void setPackPeiliao(String packPeiliao) {
        this.packPeiliao = packPeiliao;
    }

    public String getPackCaihe() {
        return packCaihe;
    }

    public void setPackCaihe(String packCaihe) {
        this.packCaihe = packCaihe;
    }

    public String getPackDakat() {
        return packDakat;
    }

    public void setPackDakat(String packDakat) {
        this.packDakat = packDakat;
    }

    public String getPackIsBiaotie() {
        return packIsBiaotie;
    }

    public void setPackIsBiaotie(String packIsBiaotie) {
        this.packIsBiaotie = packIsBiaotie;
    }

    public Boolean getPackUpdateRate() {
        return packUpdateRate;
    }

    public void setPackUpdateRate(Boolean packUpdateRate) {
        this.packUpdateRate = packUpdateRate;
    }

    public String getPackBaudRate() {
        return packBaudRate;
    }

    public void setPackBaudRate(String packBaudRate) {
        this.packBaudRate = packBaudRate;
    }

    public Boolean getPackIsCheck() {
        return packIsCheck;
    }

    public void setPackIsCheck(Boolean packIsCheck) {
        this.packIsCheck = packIsCheck;
    }

    public String getPackImeiStart() {
        return packImeiStart;
    }

    public void setPackImeiStart(String packImeiStart) {
        this.packImeiStart = packImeiStart;
    }

    public String getPackImeiEnd() {
        return packImeiEnd;
    }

    public void setPackImeiEnd(String packImeiEnd) {
        this.packImeiEnd = packImeiEnd;
    }

    public String getPackBiaotieNo() {
        return packBiaotieNo;
    }

    public void setPackBiaotieNo(String packBiaotieNo) {
        this.packBiaotieNo = packBiaotieNo;
    }

    public String getPackTangdaiNo() {
        return packTangdaiNo;
    }

    public void setPackTangdaiNo(String packTangdaiNo) {
        this.packTangdaiNo = packTangdaiNo;
    }

    public String getProSnStart() {
        return proSnStart;
    }

    public void setProSnStart(String proSnStart) {
        this.proSnStart = proSnStart;
    }

    public String getProSnEnd() {
        return proSnEnd;
    }

    public void setProSnEnd(String proSnEnd) {
        this.proSnEnd = proSnEnd;
    }

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getProCreateUser() {
        return proCreateUser;
    }

    public void setProCreateUser(String proCreateUser) {
        this.proCreateUser = proCreateUser;
    }

    public String getConfUser() {
        return confUser;
    }

    public void setConfUser(String confUser) {
        this.confUser = confUser;
    }

    public String getProTechUser() {
        return proTechUser;
    }

    public void setProTechUser(String proTechUser) {
        this.proTechUser = proTechUser;
    }

    public String getSoftManUser() {
        return softManUser;
    }

    public void setSoftManUser(String softManUser) {
        this.softManUser = softManUser;
    }

    public String getProManUser() {
        return proManUser;
    }

    public void setProManUser(String proManUser) {
        this.proManUser = proManUser;
    }
}
