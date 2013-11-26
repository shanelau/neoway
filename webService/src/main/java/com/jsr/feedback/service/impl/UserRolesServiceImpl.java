package com.jsr.feedback.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.UsersRoles;
import com.jsr.feedback.dao.UserRolesDao;
import com.jsr.feedback.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
@Service("UserRolesService")
public class UserRolesServiceImpl extends BaseService<UsersRoles, Integer> implements UserRolesService {
    UserRolesDao userRolesDao;
    @Autowired
    @Qualifier("userRolesDao")
    @Override
    public void setBaseDao(IBaseDao<UsersRoles, Integer> baseDao) {
        this.baseDao = baseDao;
        this.userRolesDao = (UserRolesDao)baseDao;
    }
    public List<UsersRoles> findByUserId(int id){
        return userRolesDao.findByUserId(id);
    }

    @Override
    public void deleteByUserIdRoleId(Integer userId, Integer roleId) {
        userRolesDao.deleteByUserIdRoleId(userId,roleId);
    }

    @Override
    public void addByUserIdRoleId(Integer userId, Integer roleId) {
        userRolesDao.addByUserIdRoleId(userId,roleId);
    }

}
