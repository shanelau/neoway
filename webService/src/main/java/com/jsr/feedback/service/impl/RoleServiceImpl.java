package com.jsr.feedback.service.impl;


import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.Roles;
import com.jsr.feedback.dao.RoleDao;
import com.jsr.feedback.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-5
 * Time: 下午1:56
 * To change this template use File | Settings | File Templates.
 */
@Service("RoleService")
public class RoleServiceImpl extends BaseService<Roles,Integer> implements RoleService {
    RoleDao rolesDao;

    @Autowired
    @Qualifier("RoleDao")
    @Override
    public void setBaseDao(IBaseDao<Roles, Integer> baseDao) {
        this.baseDao = baseDao;
        this.rolesDao = (RoleDao) baseDao;
    }
}
