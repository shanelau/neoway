package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.Roles;
import cn.neoway.cloud.dao.RoleDao;
import cn.neoway.cloud.service.RolePermissionService;
import cn.neoway.cloud.service.RoleService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
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
