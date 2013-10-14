package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.ManuInfo;
import cn.neoway.cloud.dao.ManuInfoDao;
import cn.neoway.common.dao.hibernate4.BaseHibernateDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
@Repository("ManuInfoDao")
public class ManuInfoDaoImpl extends BaseHibernateDao<ManuInfo,Integer> implements ManuInfoDao {
}
