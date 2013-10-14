package cn.neoway.cloud.bean;

import cn.neoway.common.model.AbstractModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "conf_info", schema = "", catalog = "neoway")
@Entity
public class ConfInfo extends AbstractModel {
    private int confFileId;
    private String confFileName;
    private String confPath;
    private Timestamp uploadDate;
    private String remark;

    @javax.persistence.Column(name = "conf_file_id")
    @Id
    @GeneratedValue
    public int getConfFileId() {
        return confFileId;
    }

    public void setConfFileId(int confFileId) {
        this.confFileId = confFileId;
    }

    @javax.persistence.Column(name = "conf_file_name")
    @Basic
    public String getConfFileName() {
        return confFileName;
    }

    public void setConfFileName(String confFileName) {
        this.confFileName = confFileName;
    }

    @javax.persistence.Column(name = "conf_path")
    @Basic
    public String getConfPath() {
        return confPath;
    }

    public void setConfPath(String confPath) {
        this.confPath = confPath;
    }

    @javax.persistence.Column(name = "upload_date")
    @Basic
    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    @javax.persistence.Column(name = "remark")
    @Basic
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfInfo confInfo = (ConfInfo) o;

        if (confFileId != confInfo.confFileId) return false;
        if (confFileName != null ? !confFileName.equals(confInfo.confFileName) : confInfo.confFileName != null)
            return false;
        if (confPath != null ? !confPath.equals(confInfo.confPath) : confInfo.confPath != null) return false;
        if (remark != null ? !remark.equals(confInfo.remark) : confInfo.remark != null) return false;
        if (uploadDate != null ? !uploadDate.equals(confInfo.uploadDate) : confInfo.uploadDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = confFileId;
        result = 31 * result + (confFileName != null ? confFileName.hashCode() : 0);
        result = 31 * result + (confPath != null ? confPath.hashCode() : 0);
        result = 31 * result + (uploadDate != null ? uploadDate.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
