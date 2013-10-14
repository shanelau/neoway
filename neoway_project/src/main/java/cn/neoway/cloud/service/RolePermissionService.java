package cn.neoway.cloud.service;

import cn.neoway.cloud.bean.RolesPermissions;
import cn.neoway.common.service.IBaseService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午4:11
 * To change this template use File | Settings | File Templates.
 */
public interface RolePermissionService extends IBaseService<RolesPermissions,Integer>{
    List<RolesPermissions> findPermissionByRoleId(int id);
}
