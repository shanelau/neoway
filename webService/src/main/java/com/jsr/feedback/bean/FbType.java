package com.jsr.feedback.bean;

import com.jsr.common.model.AbstractModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-19
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "fb_type", schema = "")
@Entity
public class FbType extends AbstractModel {
    private int typeId;

    @javax.persistence.Column(name = "type_Id")
    @Id
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    private String typeName;

    @javax.persistence.Column(name = "type_Name")
    @Basic
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private String typeDesc;

    @javax.persistence.Column(name = "type_Desc")
    @Basic
    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FbType fbType = (FbType) o;

        if (typeId != fbType.typeId) return false;
        if (typeDesc != null ? !typeDesc.equals(fbType.typeDesc) : fbType.typeDesc != null) return false;
        if (typeName != null ? !typeName.equals(fbType.typeName) : fbType.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (typeDesc != null ? typeDesc.hashCode() : 0);
        return result;
    }

    private Collection<FbFeedbacks> fbFeedbacksesByTypeId;

    @OneToMany(mappedBy = "fbTypeByTypeId")
    public Collection<FbFeedbacks> getFbFeedbacksesByTypeId() {
        return fbFeedbacksesByTypeId;
    }

    public void setFbFeedbacksesByTypeId(Collection<FbFeedbacks> fbFeedbacksesByTypeId) {
        this.fbFeedbacksesByTypeId = fbFeedbacksesByTypeId;
    }
}
