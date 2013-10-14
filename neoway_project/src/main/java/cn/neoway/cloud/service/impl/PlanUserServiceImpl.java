package cn.neoway.cloud.service.impl;

import cn.neoway.cloud.bean.*;
import cn.neoway.cloud.dao.ConfInfoDao;
import cn.neoway.cloud.dao.PlanUserDao;
import cn.neoway.cloud.model.ProjectModel;
import cn.neoway.cloud.model.SimplePlanModel;
import cn.neoway.cloud.service.*;
import cn.neoway.common.Constants;
import cn.neoway.common.dao.IBaseDao;
import cn.neoway.common.service.impl.BaseService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-21
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
@Service("PlanUserService")
public class PlanUserServiceImpl extends BaseService<PlanUser,Integer> implements PlanUserService {
    PlanUserDao planUserDao;
    @Autowired
    @Qualifier("ProStatetTypeService")
    ProStatetTypeService proStatetTypeService;

    @Autowired
    @Qualifier("PlanUserDao")
    @Override
    public void setBaseDao(IBaseDao<PlanUser, Integer> baseDao) {
          this.baseDao = baseDao;
           this.planUserDao = (PlanUserDao) baseDao;
    }


    @Override
    public List<PlanUser> getListByPlanType(int id) {
        return planUserDao.getListByPlanType(id);
    }
    /**
     *  根据需要处理的计划单
     * @return
     */
    public List getDealProjectList() {
        //当计划单状态id  和 计划单处理用户类别id相等 时。 则为需要处理这个计划单的 planUser 对象。
        List<PlanUser> dealPlanUserList =planUserDao.getReversalListByType(Constants.PLAN_STATE_SUCCESS);
        List list = getDealList(dealPlanUserList);
        return list;
    }

    private List getDealList(List<PlanUser> dealPlanUserList) {
        List list = new ArrayList();
        for(PlanUser pu :dealPlanUserList){
            Project pro = pu.getProjectByProPlanId();     //计划单
            SimplePlanModel spm = new SimplePlanModel();           //封装的计划单数据
            spm.setProPlanId(pro.getProPlanId());
            spm.setModuleProId(pro.getModuleProId());
            spm.setProCreateDate(pro.getProCreateDate());
            spm.setMkType(pro.getMkType());
            spm.setProceCount(pro.getProceCount());
            spm.setDealUser(pu.getUsersByUserId());
            spm.setPlanState(pu.getPlanUserTypeByPlanUserTypeId().getPlanUserTypeId()+"");
            PlanUser lastPU;
            try{
                lastPU = getByDealuser(pu.getPlanUserListId1(),pu.getUsersByUserId().getUserName());
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
            String advice ="处理顺序,轮到您了。";
            Users lastUser = null;
            if(lastPU !=null){
                advice = lastPU.getDealAdvice()==null?"":lastPU.getDealAdvice();
                lastUser = lastPU.getUsersByUserId();
            }
            spm.setDealAdvice(advice);
            spm.setLastUser(lastUser);
            list.add(spm);
        }
        return list;
    }

    /**
     *  根据已经完成的计划单
     * @return
     */
    public List getFinishProjectList() {
        //当计划单状态id  和 计划单处理用户类别id相等 时。 则为需要处理这个计划单的 planUser 对象。
        ProStateType proState = proStatetTypeService.get(Constants.PLAN_STATE_SUCCESS);
        Collection<Project> dealPlanUserList = proState.getProjectsByProPlanStateId();
        List list = new ArrayList();
        for(Project pro :dealPlanUserList){
            SimplePlanModel spm = new SimplePlanModel();           //封装的计划单数据
            spm.setProPlanId(pro.getProPlanId());
            spm.setModuleProId(pro.getModuleProId());
            spm.setProCreateDate(pro.getProCreateDate());
            spm.setMkType(pro.getMkType());
            spm.setProceCount(pro.getProceCount());
            spm.setAccomplishDate(pro.getAccomplishDate());
            list.add(pro);
        }
        return list;
    }

    @Override
    public List getUserListByProjectId(int proPlanId) {
        return planUserDao.getUserListByProjectId(proPlanId);
    }

    @Override
    public PlanUser getPlanUser(String moduleId, int stateId) {
        return planUserDao.getPlanUser(moduleId,stateId);
    }

    @Override
    public PlanUser getByDealuser(Integer planUserId, String dealUser) {

        return planUserDao.getByDealuser(planUserId,dealUser);
    }

    @Override
    public PlanUser findDealUser(Integer planUserId, String dealUser) {
        return planUserDao.findDealUser(planUserId,dealUser);
    }

    @Override
    public PlanUser findDealUser(Integer planUserId, int stateId) {
        return planUserDao.findDealUser(planUserId,stateId);
    }

    /**
     *     获取最近的计划单的 第一页
     */

    @Override
    public List getRecentlListByType(int pageNum,int pageSize ) {
        List<PlanUser> dealPlanUserList =planUserDao.getRecentlListByType(pageNum,pageSize,Constants.PLAN_STATE_SUCCESS);
        List list = getDealList(dealPlanUserList);
        return list;
    }


}
