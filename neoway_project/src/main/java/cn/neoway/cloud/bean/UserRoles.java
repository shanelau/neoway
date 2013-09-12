package cn.neoway.cloud.bean;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "user_roles", schema = "", catalog = "neoway")
@Entity
public class UserRoles {
    private int userRoleId;

    @javax.persistence.Column(name = "user_role_id")
    @Id
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    private String userRoleDesc;

    @javax.persistence.Column(name = "user_role_desc")
    @Basic
    public String getUserRoleDesc() {
        return userRoleDesc;
    }

    public void setUserRoleDesc(String userRoleDesc) {
        this.userRoleDesc = userRoleDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (userRoleId != userRoles.userRoleId) return false;
        if (userRoleDesc != null ? !userRoleDesc.equals(userRoles.userRoleDesc) : userRoles.userRoleDesc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId;
        result = 31 * result + (userRoleDesc != null ? userRoleDesc.hashCode() : 0);
        return result;
    }

    private Users usersByUserId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    private Roles rolesByRoleId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
}
