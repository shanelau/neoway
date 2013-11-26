package com.jsr.feedback.dao.impl;


import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.feedback.bean.UsersRoles;
import com.jsr.feedback.dao.UserRolesDao;
import com.jsr.feedback.model.UserRolesQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
@Repository("userRolesDao")
public class UserRolesDaoImpl extends BaseHibernateDao<UsersRoles,Integer> implements UserRolesDao {
    private static final String HQL_LIST = "from UserRoles ";
    private static final String HQL_FIND_BY_USERId = HQL_LIST+"where user_id = ?";
    private static final String HQL_DELETE_BY_USERID_ROLEID = "delete from UserRoles ur where ur.rolesByRoleId.roleId=? and ur.usersByUserId.userId=?";
    private static final String HQL_ADD_BY_USERID_ROLEID = "insert into UserRoles(rolesByRoleId.roleId,usersByUserId.userId) values(?,?)" ;
    @Override
    public List<UsersRoles> query(int pn, int pageSize, UserRolesQueryModel command) {
        return null;
    }

    @Override
    public List<UsersRoles> findByUserId(int id) {
       return list(HQL_FIND_BY_USERId,-1,-1,id);
    }

    @Override
    public void deleteByUserIdRoleId(Integer userId, Integer roleId) {
        execteBulk(HQL_DELETE_BY_USERID_ROLEID,roleId,userId);
    }

    @Override
    public void addByUserIdRoleId(Integer userId, Integer roleId) {
          execteBulk(HQL_ADD_BY_USERID_ROLEID,roleId,userId);
    }
}
