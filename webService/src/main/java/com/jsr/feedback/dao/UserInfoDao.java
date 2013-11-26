package com.jsr.feedback.dao;

import com.jsr.common.dao.IBaseDao;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.model.UserQueryModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 上午10:56
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoDao extends IBaseDao<Users, Integer> {
    List<Users> query(int pn, int pageSize, UserQueryModel command);
    int countQuery(UserQueryModel command);
    Users findByUserName(String username);

    List<Users> listByKeyword(String keyword);
}
