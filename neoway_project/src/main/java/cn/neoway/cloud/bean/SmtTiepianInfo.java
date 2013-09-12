package cn.neoway.cloud.bean;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "smt_tiepian_info", schema = "", catalog = "neoway")
@Entity
public class SmtTiepianInfo {
    private int smtId;

    @javax.persistence.Column(name = "smt_id")
    @Id
    public int getSmtId() {
        return smtId;
    }

    public void setSmtId(int smtId) {
        this.smtId = smtId;
    }

    private String pcbName;

    @javax.persistence.Column(name = "pcb_name")
    @Basic
    public String getPcbName() {
        return pcbName;
    }

    public void setPcbName(String pcbName) {
        this.pcbName = pcbName;
    }

    private String pcbaCode;

    @javax.persistence.Column(name = "pcba_code")
    @Basic
    public String getPcbaCode() {
        return pcbaCode;
    }

    public void setPcbaCode(String pcbaCode) {
        this.pcbaCode = pcbaCode;
    }

    private String hardwareEditon;

    @javax.persistence.Column(name = "hardware_editon")
    @Basic
    public String getHardwareEditon() {
        return hardwareEditon;
    }

    public void setHardwareEditon(String hardwareEditon) {
        this.hardwareEditon = hardwareEditon;
    }

    private String tiepianFile;

    @javax.persistence.Column(name = "tiepian_file")
    @Basic
    public String getTiepianFile() {
        return tiepianFile;
    }

    public void setTiepianFile(String tiepianFile) {
        this.tiepianFile = tiepianFile;
    }

    private String pcbLiaodan;

    @javax.persistence.Column(name = "pcb_liaodan")
    @Basic
    public String getPcbLiaodan() {
        return pcbLiaodan;
    }

    public void setPcbLiaodan(String pcbLiaodan) {
        this.pcbLiaodan = pcbLiaodan;
    }

    private Timestamp smtDate;

    @javax.persistence.Column(name = "smt_date")
    @Basic
    public Timestamp getSmtDate() {
        return smtDate;
    }

    public void setSmtDate(Timestamp smtDate) {
        this.smtDate = smtDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmtTiepianInfo that = (SmtTiepianInfo) o;

        if (smtId != that.smtId) return false;
        if (hardwareEditon != null ? !hardwareEditon.equals(that.hardwareEditon) : that.hardwareEditon != null)
            return false;
        if (pcbLiaodan != null ? !pcbLiaodan.equals(that.pcbLiaodan) : that.pcbLiaodan != null) return false;
        if (pcbName != null ? !pcbName.equals(that.pcbName) : that.pcbName != null) return false;
        if (pcbaCode != null ? !pcbaCode.equals(that.pcbaCode) : that.pcbaCode != null) return false;
        if (smtDate != null ? !smtDate.equals(that.smtDate) : that.smtDate != null) return false;
        if (tiepianFile != null ? !tiepianFile.equals(that.tiepianFile) : that.tiepianFile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = smtId;
        result = 31 * result + (pcbName != null ? pcbName.hashCode() : 0);
        result = 31 * result + (pcbaCode != null ? pcbaCode.hashCode() : 0);
        result = 31 * result + (hardwareEditon != null ? hardwareEditon.hashCode() : 0);
        result = 31 * result + (tiepianFile != null ? tiepianFile.hashCode() : 0);
        result = 31 * result + (pcbLiaodan != null ? pcbLiaodan.hashCode() : 0);
        result = 31 * result + (smtDate != null ? smtDate.hashCode() : 0);
        return result;
    }

    private Collection<Project> projectsBySmtId;

    @OneToMany(mappedBy = "smtTiepianInfoBySmtId")
    public Collection<Project> getProjectsBySmtId() {
        return projectsBySmtId;
    }

    public void setProjectsBySmtId(Collection<Project> projectsBySmtId) {
        this.projectsBySmtId = projectsBySmtId;
    }
}
