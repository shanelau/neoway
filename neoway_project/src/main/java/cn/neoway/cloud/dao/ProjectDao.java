package cn.neoway.cloud.dao;

import cn.neoway.cloud.bean.ConfInfo;
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
public interface ProjectDao extends IBaseDao<Project,Integer> {
    Project findByModuleProId(String id);
    /**
     *
     * @param id  计划编号
     * @returnp 配置文件信息
     */
    ConfInfo findConfigByProjectId(int id);

    List<Project> getDealProject(int type_id);
}
