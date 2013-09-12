package cn.neoway.cloud.dao.hibernate4;

import cn.neoway.cloud.bean.Users;
import cn.neoway.cloud.dao.UserInfoDao;
import cn.neoway.common.dao.hibernate4.BaseHibernateDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-12
 * Time: 上午10:58
 * To change this template use File | Settings | File Templates.
 */
@Repository("UserInfoDao")
public class UserInfoDaoImpl extends BaseHibernateDao<Users, Integer> implements UserInfoDao {
    private static final String HQL_LIST = "from Users ";
    private static final String HQL_FIND_BY_USERNAME = HQL_LIST+"where user_name = ?";
    @Override
    public List<Users> query(int pn, int pageSize, Users command) {
        return null;
    }

    @Override
    public int countQuery(Users command) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Users findByUserName(String username) {
        return unique(HQL_FIND_BY_USERNAME,username);
    }
}
