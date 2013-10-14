package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.Roles;
import cn.neoway.cloud.dao.RoleDao;
import cn.neoway.common.dao.hibernate4.BaseHibernateDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-5
 * Time: 下午1:58
 * To change this template use File | Settings | File Templates.
 */
@Repository("RoleDao")
public class RoleDaoImpl extends BaseHibernateDao<Roles, Integer> implements RoleDao {
}
