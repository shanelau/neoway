package cn.neoway.cloud.dao;

import cn.neoway.cloud.bean.PlanUser;
import cn.neoway.cloud.bean.Project;
import cn.neoway.common.dao.IBaseDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
public interface PlanUserDao extends IBaseDao<PlanUser,Integer> {
    List<PlanUser> getListByPlanType(int id);
    public List<PlanUser> getReversalListByType(int id);
    public List<PlanUser> getRecentlListByType(int pageSize,int pageNum,int id);

    List getUserListByProjectId(int proPlanId);

    PlanUser getPlanUser(String moduleId, int stateId);

    PlanUser getByDealuser(Integer planUserId, String dealUser);
    public PlanUser findDealUser(Integer planUserId, String dealUser);

    PlanUser findDealUser(Integer planUserId, int stateId);
}
