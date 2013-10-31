package cn.neoway.cloud.dao.hibernate4;

import cn.neoway.cloud.bean.Roles;
import cn.neoway.cloud.bean.UserRoles;
import cn.neoway.cloud.dao.UserRolesDao;
import cn.neoway.cloud.model.UserRolesQueryModel;
import cn.neoway.common.dao.hibernate4.BaseHibernateDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-14
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
@Repository("userRolesDao")
public class UserRolesDaoImpl extends BaseHibernateDao<UserRoles, Integer> implements UserRolesDao {
    private static final String HQL_LIST = "from UserRoles ";
    private static final String HQL_FIND_BY_USERId = HQL_LIST + "where user_id = ?";

    @Override
    public List<UserRoles> query(int pn, int pageSize, UserRolesQueryModel command) {
        return null;
    }

    @Override
    public List<UserRoles> findByUserId(int id) {
        return list(HQL_FIND_BY_USERId, -1, -1, id);
    }
}
