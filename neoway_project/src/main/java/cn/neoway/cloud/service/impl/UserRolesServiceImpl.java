package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.UserRoles;
import cn.neoway.cloud.dao.UserRolesDao;
import cn.neoway.cloud.service.UserRolesService;
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
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
@Service("UserRolesService")
public class UserRolesServiceImpl extends BaseService<UserRoles, Integer> implements UserRolesService{
    UserRolesDao userRolesDao;
    @Autowired
    @Qualifier("userRolesDao")
    @Override
    public void setBaseDao(IBaseDao<UserRoles, Integer> baseDao) {
        this.baseDao = baseDao;
        this.userRolesDao = (UserRolesDao)baseDao;
    }
    public List<UserRoles> findByUserId(int id){
        return userRolesDao.findByUserId(id);
    }
}
