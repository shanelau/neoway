package com.jsr.feedback.service;
import com.jsr.common.pagination.Page;
import com.jsr.common.service.IBaseService;
import com.jsr.feedback.bean.Users;
import com.jsr.feedback.model.UserQueryModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 上午11:04
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoService extends IBaseService<Users, Integer> {
    Page<Users> query(int pn, int pageSize, UserQueryModel command);
    Users findUserByName(String username);

    List<Users> listByKeyword(String keyword);

    String updateForgetPassword(String username,String basePath) throws Exception;
    Users save(Users users,int roleId);
}
