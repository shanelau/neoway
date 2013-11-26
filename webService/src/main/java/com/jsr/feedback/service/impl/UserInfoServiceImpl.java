package com.jsr.feedback.service.impl;

import com.jsr.common.dao.IBaseDao;
import com.jsr.common.pagination.Page;
import com.jsr.common.pagination.PageUtil;
import com.jsr.common.service.impl.BaseService;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.dao.UserInfoDao;
import com.jsr.feedback.model.UserQueryModel;
import com.jsr.feedback.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
@Service("UserInfoService")
public class UserInfoServiceImpl extends BaseService<Users, Integer> implements UserInfoService {
    private UserInfoDao userInfoDao;

    @Autowired
    @Qualifier("UserInfoDao")
    @Override
    public void setBaseDao(IBaseDao<Users, Integer> userInfoDao) {
        this.baseDao = userInfoDao;
        this.userInfoDao = (UserInfoDao)userInfoDao;
    }

    @Override
    public Users findUserByName(String username) {
        return userInfoDao.findByUserName(username);
    }

    @Override
    public List<Users> listByKeyword(String keyword) {
        return userInfoDao.listByKeyword(keyword);
    }

    @Override
    public Page<Users> query(int pn, int pageSize, UserQueryModel command) {
        return PageUtil.getPage(userInfoDao.countQuery(command), pn, userInfoDao.query(pn, pageSize, command), pageSize);
    }
}
