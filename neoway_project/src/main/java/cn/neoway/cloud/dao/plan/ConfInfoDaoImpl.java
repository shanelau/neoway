package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.ConfInfo;
import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.dao.ConfInfoDao;
import cn.neoway.cloud.dao.ProjectDao;
import cn.neoway.common.dao.hibernate4.BaseHibernateDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
@Repository("ConfInfoDao")
public class ConfInfoDaoImpl extends BaseHibernateDao<ConfInfo, Integer> implements ConfInfoDao {

}
