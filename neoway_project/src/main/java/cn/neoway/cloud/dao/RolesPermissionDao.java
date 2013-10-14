package cn.neoway.cloud.dao;

import cn.neoway.cloud.bean.RolesPermissions;
import cn.neoway.common.dao.IBaseDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
public interface RolesPermissionDao extends IBaseDao<RolesPermissions,Integer>{
    List<RolesPermissions> findListByRoleId(int id);
}
