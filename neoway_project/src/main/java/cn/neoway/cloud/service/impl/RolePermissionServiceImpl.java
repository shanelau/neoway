package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.RolesPermissions;
import cn.neoway.cloud.dao.hibernate4.RolesPermissionDaoImpl;
import cn.neoway.cloud.service.RolePermissionService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
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
    RolesPermissionDaoImpl rolePermissionDao;
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
