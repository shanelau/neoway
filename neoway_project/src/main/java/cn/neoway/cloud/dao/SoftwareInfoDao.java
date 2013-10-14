package cn.neoway.cloud.dao;

import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.common.dao.IBaseDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
public interface SoftwareInfoDao extends IBaseDao<SoftwareInfo,Integer> {
    List<SoftwareInfo> getNullFileByTypeId();
}
