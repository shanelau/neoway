package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.SysEmail;
import cn.neoway.cloud.dao.SysEmailDao;
import cn.neoway.common.dao.hibernate4.BaseHibernateDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-8
 * Time: 上午8:45
 * To change this template use File | Settings | File Templates.
 */
@Repository("SysEmailDao")
public class SysEmailDaoImpl extends BaseHibernateDao<SysEmail,Integer> implements SysEmailDao{
}
