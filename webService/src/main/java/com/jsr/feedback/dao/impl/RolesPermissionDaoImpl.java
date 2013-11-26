package com.jsr.feedback.dao.impl;


import com.jsr.common.dao.hibernate4.BaseHibernateDao;
import com.jsr.feedback.bean.RolesPermissions;
import com.jsr.feedback.dao.RolesPermissionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午4:17
 * To change this template use File | Settings | File Templates.
 */
@Repository("RolesPermissionDao")
public class RolesPermissionDaoImpl extends BaseHibernateDao<RolesPermissions,Integer> implements RolesPermissionDao {
    private static final String HQL = " from RolesPermissions";
    private static final String HQL_BY_ROLE_ID =HQL+ " where role_id = ?";
    @Override
    public List<RolesPermissions> findListByRoleId(int id) {
        return list(HQL_BY_ROLE_ID,-1,-1,id);
    }
}
