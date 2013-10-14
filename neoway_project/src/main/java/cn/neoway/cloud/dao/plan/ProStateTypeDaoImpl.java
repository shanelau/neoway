package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.ProStateType;
import cn.neoway.cloud.dao.ProStatetTypeDao;
import cn.neoway.common.dao.hibernate4.BaseHibernateDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
@Repository("ProStatetTypeDao")
public class ProStateTypeDaoImpl extends BaseHibernateDao<ProStateType, Integer> implements ProStatetTypeDao {

}
