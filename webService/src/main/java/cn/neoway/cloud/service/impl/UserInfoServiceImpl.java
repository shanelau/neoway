package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.Users;
import cn.neoway.cloud.dao.UserInfoDao;
import cn.neoway.cloud.model.UserQueryModel;
import cn.neoway.cloud.service.UserInfoService;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.pagination.Page;
import cn.neoway.common.pagination.PageUtil;
import cn.neoway.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
@Service("userService")
public class UserInfoServiceImpl extends BaseService<Users, Integer> implements UserInfoService {
    private UserInfoDao userInfoDao;

    @Autowired
    @Qualifier("UserInfoDao")
    @Override
    public void setBaseDao(IBaseDao<Users, Integer> userInfoDao) {
        this.baseDao = userInfoDao;
        this.userInfoDao = (UserInfoDao) userInfoDao;
    }

    @Override
    public Users findUserByName(String username) {
        return userInfoDao.findByUserName(username);
    }

    @Override
    public Page<Users> query(int pn, int pageSize, UserQueryModel command) {
        return PageUtil.getPage(userInfoDao.countQuery(command), pn, userInfoDao.query(pn, pageSize, command), pageSize);
    }
}
