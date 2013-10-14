package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.PlanUser;
import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.dao.PlanUserDao;
import cn.neoway.cloud.dao.ProjectDao;
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
@Repository("PlanUserDao")
public class PlanUserDaoImpl extends BaseHibernateDao<PlanUser, Integer> implements PlanUserDao {
    String  HQL_FIND_FIND_INVESER_LIST= " from PlanUser p where p.projectByProPlanId.proStateTypeByProPlanStateId.proPlanStateId != ? and " +
            "p.projectByProPlanId.proStateTypeByProPlanStateId.proPlanStateId = p.planUserTypeByPlanUserTypeId.planUserTypeId";                       //注意是 不等于  。需要处理的计划单
    String HQL_FIND_BY_PLAN_STATE = "select DISTINCT  *  from PlanUser p where p.projectByProPlanId.proStateTypeByProPlanStateId.proPlanStateId = ?";
    String HQL_FIND_BY_PROJECT_ID = " from PlanUser p where p.projectByProPlanId.proPlanId = ?";
    String HQL_FIND_BY_MODULEID_STATEID = " from PlanUser p where p.projectByProPlanId.moduleProId = ? and p.planUserTypeByPlanUserTypeId.planUserTypeId = ?";
    String HQL_FIND_BY_DEALUSER_AND_PLANUSERID =" from PlanUser p where p.dealUser = ? and p.projectByProPlanId.proPlanId = (select p2.projectByProPlanId.proPlanId from PlanUser p2 where p2.planUserListId1 = ?)";

    String HQL_FIND_DEALUSER_BY_PLANUSERID =" from PlanUser p where p.usersByUserId.userName = ? and p.projectByProPlanId.proPlanId = (select p2.projectByProPlanId.proPlanId from PlanUser p2 where p2.planUserListId1 = ?)";
   String HQL_FIND_DEALUSER_PLANUSERID_STATEID = "from PlanUser p where p.projectByProPlanId.proPlanId = (select p2.projectByProPlanId.proPlanId from PlanUser p2 where p2.planUserListId1 = ?) and p.planUserTypeByPlanUserTypeId.planUserTypeId = ?" ;

    @Override
    public List<PlanUser> getListByPlanType(int id) {
        return list(HQL_FIND_BY_PLAN_STATE,-1,Integer.MAX_VALUE,id);
    }
   //获取所有计划单
    public List<PlanUser> getReversalListByType(int id){
        return list(HQL_FIND_FIND_INVESER_LIST,-1,Integer.MAX_VALUE,id);
    }

    public List<PlanUser> getRecentlListByType(int pageNum,int pageSize,int id){
        return list(HQL_FIND_FIND_INVESER_LIST,pageNum,pageSize,id);
    }

    @Override
    public List getUserListByProjectId(int proPlanId) {
        return list(HQL_FIND_BY_PROJECT_ID,-1,Integer.MAX_VALUE,proPlanId);
    }

    @Override
    public PlanUser getPlanUser(String moduleId, int stateId) {
        return unique(HQL_FIND_BY_MODULEID_STATEID,moduleId,stateId);
    }

    @Override
    public PlanUser getByDealuser(Integer planUserId, String dealUser) {
        return unique(HQL_FIND_BY_DEALUSER_AND_PLANUSERID ,dealUser,planUserId);
    }
    @Override
    public PlanUser findDealUser(Integer planUserId, String dealUser) {
        return unique(HQL_FIND_DEALUSER_BY_PLANUSERID ,dealUser,planUserId);
    }

    @Override
    public PlanUser findDealUser(Integer planUserId, int stateId) {
        return unique(HQL_FIND_DEALUSER_PLANUSERID_STATEID,planUserId,stateId);
    }
}
