package cn.neoway.cloud.service;

import cn.neoway.cloud.bean.*;
import cn.neoway.cloud.model.ProjectModel;
import cn.neoway.common.service.IBaseService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
public interface PlanUserService extends IBaseService<PlanUser,Integer> {
    List<PlanUser> getListByPlanType(int id);
    public List getDealProjectList();
    public List getFinishProjectList();

    List getUserListByProjectId(int proPlanId);

    PlanUser getPlanUser(String moduleId, int stateId);

    PlanUser getByDealuser(Integer planUserId, String dealUser);

    PlanUser findDealUser(Integer planUserId, String dealUser);

    PlanUser findDealUser(Integer planUserId, int stateId);

    List getRecentlListByType(int pageNum, int pageSize);
}
