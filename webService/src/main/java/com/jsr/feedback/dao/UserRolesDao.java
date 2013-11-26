package com.jsr.feedback.dao;



import com.jsr.common.dao.IBaseDao;
import com.jsr.feedback.bean.UsersRoles;
import com.jsr.feedback.model.UserRolesQueryModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */
public interface UserRolesDao extends IBaseDao<UsersRoles,Integer> {
    List<UsersRoles> query(int pn, int pageSize, UserRolesQueryModel command);
    List<UsersRoles> findByUserId(int userId);

    void deleteByUserIdRoleId(Integer userId, Integer roleId);

    void addByUserIdRoleId(Integer userId, Integer roleId);
}
