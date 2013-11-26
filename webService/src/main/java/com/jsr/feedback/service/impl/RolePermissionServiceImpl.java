package com.jsr.feedback.service.impl;


import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.RolesPermissions;
import com.jsr.feedback.dao.impl.RolesPermissionDaoImpl;
import com.jsr.feedback.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
@Service("RolePermissionService")
public class RolePermissionServiceImpl extends BaseService<RolesPermissions,Integer> implements RolePermissionService {
    @Autowired
    @Qualifier("RolesPermissionDao")
    com.jsr.feedback.dao.impl.RolesPermissionDaoImpl rolePermissionDao;
    @Override
    public void setBaseDao(IBaseDao<RolesPermissions, Integer> baseDao) {
        this.baseDao = baseDao;
        rolePermissionDao =  (RolesPermissionDaoImpl)baseDao;
    }

    @Override
    public List<RolesPermissions> findPermissionByRoleId(int id) {
        return rolePermissionDao.findListByRoleId(id);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
