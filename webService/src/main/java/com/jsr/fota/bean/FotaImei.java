package com.jsr.fota.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 上午11:55
 * coding for fun and coding my life!
 */
@javax.persistence.Table(name = "fota_imei", schema = "")
@Entity
public class FotaImei extends AbstractModel {
    private String imei;

    public FotaImei() {
    }

    public FotaImei(String imei) {
       this.imei = imei;
       this.imeiDate = new Timestamp(System.currentTimeMillis());
    }

    @javax.persistence.Column(name = "imei")
    @Id
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }    private Timestamp imeiDate;

    @javax.persistence.Column(name = "imei_Date")
    @Basic
    public Timestamp getImeiDate() {
        return imeiDate;
    }

    public void setImeiDate(Timestamp imeiDate) {
        this.imeiDate = imeiDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FotaImei fotaImei = (FotaImei) o;

        if (imei != null ? !imei.equals(fotaImei.imei) : fotaImei.imei != null) return false;
        if (imeiDate != null ? !imeiDate.equals(fotaImei.imeiDate) : fotaImei.imeiDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imei != null ? imei.hashCode() : 0;
        result = 31 * result + (imeiDate != null ? imeiDate.hashCode() : 0);
        return result;
    }
}
