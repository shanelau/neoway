package com.jsr.feedback.service;


import com.jsr.common.service.IBaseService;
import com.jsr.feedback.bean.UsersRoles;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午3:02
 * To change this template use File | Settings | File Templates.
 */
public interface UserRolesService  extends IBaseService<UsersRoles, Integer>
{
    public List<UsersRoles> findByUserId(int id);

    void deleteByUserIdRoleId(Integer userId, Integer roleId);

    void addByUserIdRoleId(Integer userId, Integer roleId);
}
