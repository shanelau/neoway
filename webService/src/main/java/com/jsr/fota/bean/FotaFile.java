package com.jsr.fota.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 上午11:55
 * coding for fun and coding my life!
 */
@javax.persistence.Table(name = "fota_file", schema = "")
@Entity
public class FotaFile extends AbstractModel {
    private int fileId;
    private String fileName;
    private String bcsObject;
    private String url;
    private String size;
    private Integer updateTo;
    private Boolean status;
    private Timestamp fileDate;
    private FotaVersion fotaVersionByVersionId;

    @javax.persistence.Column(name = "file_Id")
    @Id
    @GeneratedValue
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @javax.persistence.Column(name = "file_Name")
    @Basic
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @javax.persistence.Column(name = "bcs_Object")
    @Basic
    public String getBcsObject() {
        return bcsObject;
    }

    public void setBcsObject(String bcsObject) {
        this.bcsObject = bcsObject;
    }

    @javax.persistence.Column(name = "url")
    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @javax.persistence.Column(name = "size")
    @Basic
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @javax.persistence.Column(name = "update_To")
    @Basic
    public Integer getUpdateTo() {
        return updateTo;
    }

    public void setUpdateTo(Integer updateTo) {
        this.updateTo = updateTo;
    }

    @javax.persistence.Column(name = "status")
    @Basic
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @javax.persistence.Column(name = "file_Date")
    @Basic
    public Timestamp getFileDate() {
        return fileDate;
    }

    public void setFileDate(Timestamp fileDate) {
        this.fileDate = fileDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FotaFile fotaFile = (FotaFile) o;

        if (fileId != fotaFile.fileId) return false;
        if (bcsObject != null ? !bcsObject.equals(fotaFile.bcsObject) : fotaFile.bcsObject != null) return false;
        if (fileDate != null ? !fileDate.equals(fotaFile.fileDate) : fotaFile.fileDate != null) return false;
        if (fileName != null ? !fileName.equals(fotaFile.fileName) : fotaFile.fileName != null) return false;
        if (size != null ? !size.equals(fotaFile.size) : fotaFile.size != null) return false;
        if (status != null ? !status.equals(fotaFile.status) : fotaFile.status != null) return false;
        if (updateTo != null ? !updateTo.equals(fotaFile.updateTo) : fotaFile.updateTo != null) return false;
        if (url != null ? !url.equals(fotaFile.url) : fotaFile.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileId;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (bcsObject != null ? bcsObject.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (updateTo != null ? updateTo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (fileDate != null ? fileDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "version_Id", referencedColumnName = "version_Id")
    public FotaVersion getFotaVersionByVersionId() {
        return fotaVersionByVersionId;
    }

    public void setFotaVersionByVersionId(FotaVersion fotaVersionByVersionId) {
        this.fotaVersionByVersionId = fotaVersionByVersionId;
    }
}
