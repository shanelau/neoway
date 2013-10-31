package cn.neoway.cloud.dao.hibernate4;

import cn.neoway.cloud.bean.Users;
import cn.neoway.cloud.dao.UserInfoDao;
import cn.neoway.cloud.model.UserQueryModel;
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
    private static final String HQL_FIND_BY_USERNAME = HQL_LIST + "where user_name = ?";
    private static final String HQL_COUNT = "select count(*) from Users ";

    private static final String HQL_LIST_QUERY_CONDITION = " where username like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<Users> query(int pn, int pageSize, UserQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQuery(UserQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }


    private Object[] getQueryParam(UserQueryModel command) {
        //TODO 改成全文索引
        String usernameLikeStr = "%" + command.getUserName() + "%";
        return new Object[]{
                usernameLikeStr
        };
    }

    @Override
    public Users findByUserName(String username) {
        return unique(HQL_FIND_BY_USERNAME, username);
    }
}
