package com.jsr.feedback.dao;
import com.jsr.common.dao.IBaseDao;
import com.jsr.feedback.bean.RolesPermissions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
public interface RolesPermissionDao extends IBaseDao<RolesPermissions,Integer> {
    List<RolesPermissions> findListByRoleId(int id);
}
