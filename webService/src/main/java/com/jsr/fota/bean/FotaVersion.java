package com.jsr.fota.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 上午11:55
 * coding for fun and coding my life!
 */
@javax.persistence.Table(name = "fota_version", schema = "")
@Entity
public class FotaVersion extends AbstractModel {

    public FotaVersion() {
    }
    public FotaVersion(int versionId, FotaBrand fotaBrand, String versionName, String versionDesc) {
        this.versionId = versionId;
        this.versionName = versionName;
        this.versionDesc = versionDesc;
        this.fotaBrandByBrandId = fotaBrand;
    }

    private int versionId;

    @javax.persistence.Column(name = "version_Id")
    @Id
    @GeneratedValue
    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    private String versionName;

    @javax.persistence.Column(name = "version_Name")
    @Basic
    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    private String versionDesc;

    @javax.persistence.Column(name = "version_desc")
    @Basic
    public String getVersionDesc() {
        return versionDesc;
    }

    public void setVersionDesc(String versionDesc) {
        this.versionDesc = versionDesc;
    }

    private String tips;

    @javax.persistence.Column(name = "tips")
    @Basic
    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    private Timestamp versionDate;

    @javax.persistence.Column(name = "version_Date")
    @Basic
    public Timestamp getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(Timestamp versionDate) {
        this.versionDate = versionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FotaVersion that = (FotaVersion) o;

        if (versionId != that.versionId) return false;
        if (tips != null ? !tips.equals(that.tips) : that.tips != null) return false;
        if (versionDate != null ? !versionDate.equals(that.versionDate) : that.versionDate != null) return false;
        if (versionDesc != null ? !versionDesc.equals(that.versionDesc) : that.versionDesc != null) return false;
        if (versionName != null ? !versionName.equals(that.versionName) : that.versionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = versionId;
        result = 31 * result + (versionName != null ? versionName.hashCode() : 0);
        result = 31 * result + (versionDesc != null ? versionDesc.hashCode() : 0);
        result = 31 * result + (tips != null ? tips.hashCode() : 0);
        result = 31 * result + (versionDate != null ? versionDate.hashCode() : 0);
        return result;
    }

    private Collection<FotaFile> fotaFilesByVersionId;

    @OneToMany(mappedBy = "fotaVersionByVersionId")
    public Collection<FotaFile> getFotaFilesByVersionId() {
        return fotaFilesByVersionId;
    }

    public void setFotaFilesByVersionId(Collection<FotaFile> fotaFilesByVersionId) {
        this.fotaFilesByVersionId = fotaFilesByVersionId;
    }

    private FotaBrand fotaBrandByBrandId;

    @ManyToOne
    @JoinColumn(name = "brand_Id", referencedColumnName = "brand_Id")
    public FotaBrand getFotaBrandByBrandId() {
        return fotaBrandByBrandId;
    }

    public void setFotaBrandByBrandId(FotaBrand fotaBrandByBrandId) {
        this.fotaBrandByBrandId = fotaBrandByBrandId;
    }
}
