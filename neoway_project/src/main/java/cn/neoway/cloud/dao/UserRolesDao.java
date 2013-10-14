package cn.neoway.cloud.dao;

import cn.neoway.cloud.bean.Roles;
import cn.neoway.cloud.bean.UserRoles;
import cn.neoway.cloud.model.UserRolesQueryModel;
import cn.neoway.common.dao.IBaseDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */
public interface UserRolesDao extends IBaseDao<UserRoles,Integer> {
    List<UserRoles> query(int pn, int pageSize, UserRolesQueryModel command);
    List<UserRoles> findByUserId(int userId);

    void deleteByUserIdRoleId(Integer userId, Integer roleId);

    void addByUserIdRoleId(Integer userId, Integer roleId);
}
