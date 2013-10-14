package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.ConfInfo;
import cn.neoway.cloud.bean.Project;
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
@Repository("ProjectDao")
public class ProjectDaoImpl extends BaseHibernateDao<Project, Integer> implements ProjectDao{
    String HQL_FIND_CONFIG_BY_PROJECT_ID = "select Project.confInfoByConfFileId from Project where proPlanId = ?";
    String  HQL_FIND_BY_PLAN_STATE= " from Project p where p.proStateTypeByProPlanStateId.proPlanStateId != ?";                       //注意是 不等于  。需要处理的计划单
    @Override
    public Project findByModuleProId(String id) {
        return unique(" from Project where moduleProId = ?",id);
    }

    @Override
    public ConfInfo findConfigByProjectId(int id) {
        return unique(HQL_FIND_CONFIG_BY_PROJECT_ID,id);
    }

    @Override
    public List<Project> getDealProject(int type_id) {
        return list(HQL_FIND_BY_PLAN_STATE,-1,Integer.MAX_VALUE,type_id);
    }
}
