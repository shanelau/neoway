package cn.neoway.cloud.dao.plan;

import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.cloud.dao.ProjectDao;
import cn.neoway.cloud.dao.SoftwareInfoDao;
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
@Repository("SoftwareInfoDao")
public class SoftwareInfoDaoImpl extends BaseHibernateDao<SoftwareInfo, Integer> implements SoftwareInfoDao {
    private static String HQL_FIND_SOFTWARE_BY_TYPEID ="from SoftwareInfo s where s.softName='无软件' and s.softRemark='未指定软件' group by s.softwareTypeBySoftTypeId.softTypeId";
    @Override
    public List<SoftwareInfo> getNullFileByTypeId() {
        return list(HQL_FIND_SOFTWARE_BY_TYPEID,-1,Integer.MAX_VALUE);
    }
}
