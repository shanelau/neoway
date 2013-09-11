package cn.neoway.cloud.dao;

import cn.neoway.cloud.model.UserModel;
import cn.neoway.cloud.model.UserQueryModel;
import cn.neoway.common.dao.IBaseDao;

import java.util.List;


public interface UserDao extends IBaseDao<UserModel, Integer> {
    
    List<UserModel> query(int pn, int pageSize, UserQueryModel command);

    int countQuery(UserQueryModel command);

}
