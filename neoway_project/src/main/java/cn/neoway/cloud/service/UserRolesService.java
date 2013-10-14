package cn.neoway.cloud.service;

import cn.neoway.cloud.bean.UserRoles;
import cn.neoway.cloud.bean.Users;
import cn.neoway.common.service.IBaseService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午3:02
 * To change this template use File | Settings | File Templates.
 */
public interface UserRolesService  extends IBaseService<UserRoles, Integer>
{
    public List<UserRoles> findByUserId(int id);

    void deleteByUserIdRoleId(Integer userId, Integer roleId);

    void addByUserIdRoleId(Integer userId, Integer roleId);
}
