package com.jsr.fota.bean;

import com.jsr.common.model.AbstractModel;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 上午11:55
 * coding for fun and coding my life!
 */
@javax.persistence.Table(name = "fota_brand", schema = "")
@Entity
public class FotaBrand extends AbstractModel{
    private int brandId;
    private String brandName;
    private String oem;
    private String product;
    private String language;
    private String operator;
    private Collection<FotaVersion> fotaVersionsByBrandId;

    public FotaBrand() {
    }

    public FotaBrand(String brandName, String oem, String product, String language) {
        this.brandName = brandName;
        this.oem = oem;
        this.product = product;
        this.language = language;
    }

    public FotaBrand(int brandId, String brandName, String oem, String product, String language) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.oem = oem;
        this.product = product;
        this.language = language;
    }

    @javax.persistence.Column(name = "brand_Id")
    @Id
    @GeneratedValue
    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @javax.persistence.Column(name = "brand_Name")
    @Basic
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @javax.persistence.Column(name = "oem")
    @Basic
    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    @javax.persistence.Column(name = "product")
    @Basic
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @javax.persistence.Column(name = "language")
    @Basic
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @javax.persistence.Column(name = "operator")
    @Basic
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FotaBrand fotaBrand = (FotaBrand) o;

        if (brandId != fotaBrand.brandId) return false;
        if (brandName != null ? !brandName.equals(fotaBrand.brandName) : fotaBrand.brandName != null) return false;
        if (language != null ? !language.equals(fotaBrand.language) : fotaBrand.language != null) return false;
        if (oem != null ? !oem.equals(fotaBrand.oem) : fotaBrand.oem != null) return false;
        if (operator != null ? !operator.equals(fotaBrand.operator) : fotaBrand.operator != null) return false;
        if (product != null ? !product.equals(fotaBrand.product) : fotaBrand.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brandId;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (oem != null ? oem.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "fotaBrandByBrandId",orphanRemoval = true)
    public Collection<FotaVersion> getFotaVersionsByBrandId() {
        return fotaVersionsByBrandId;
    }

    public void setFotaVersionsByBrandId(Collection<FotaVersion> fotaVersionsByBrandId) {
        this.fotaVersionsByBrandId = fotaVersionsByBrandId;
    }
}
