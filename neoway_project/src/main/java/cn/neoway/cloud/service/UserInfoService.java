package cn.neoway.cloud.service;

import cn.neoway.cloud.bean.Users;
import cn.neoway.common.service.IBaseService;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 上午11:04
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoService extends IBaseService<Users, Integer> {

    Users findUserByName(String username);
}
