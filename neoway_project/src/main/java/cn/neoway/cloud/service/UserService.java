/*package cn.neoway.cloud.service;

import cn.neoway.cloud.model.UserModel;
import cn.neoway.cloud.model.UserQueryModel;
import cn.neoway.common.pagination.Page;
import cn.neoway.common.service.IBaseService;
  */
/**
 * User: Zhang Kaitao
 * Date: 12-1-4 上午10:13
 * Version: 1.0

public interface UserService extends IBaseService<UserModel, Integer> {

    Page<UserModel> query(int pn, int pageSize, UserQueryModel command);
}
 */