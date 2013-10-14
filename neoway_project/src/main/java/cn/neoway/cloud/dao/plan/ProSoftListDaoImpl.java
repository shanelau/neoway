package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.ProSoftList;
import cn.neoway.cloud.dao.ProSoftListDao;
import cn.neoway.common.dao.hibernate4.BaseHibernateDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
@Repository("ProSoftListDao")
public class ProSoftListDaoImpl extends BaseHibernateDao<ProSoftList, Integer> implements ProSoftListDao {
    String HQL_FIND_PROSOFTLIST_BY_PRO_PLAN_ID = "select p from ProSoftList p inner join p.projectByProPlanId project where project.proPlanId = ?";
    String HQL_DELETE_BY_PLAN_ID = "delete from ProSoftList p where p.projectByProPlanId.proPlanId = ?";
    @Override
    public List<ProSoftList> findByProPlanId(int id) {
        return list(HQL_FIND_PROSOFTLIST_BY_PRO_PLAN_ID,-1,Integer.MAX_VALUE,id);
    }

    @Override
    public void deleteByPlanId(int planId) {
          execteBulk(HQL_DELETE_BY_PLAN_ID,planId);
    }
}
