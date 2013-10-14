package cn.neoway.cloud.service;

import cn.neoway.cloud.bean.ConfInfo;
import cn.neoway.cloud.bean.ProStateType;
import cn.neoway.cloud.bean.Project;
import cn.neoway.cloud.bean.Users;
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
public interface ProjectService extends IBaseService<Project,Integer> {
    Project findByModuleProId(String id);
    /**
     *
     * @param id  计划编号
     * @returnp 配置文件信息
     */
    ConfInfo findConfigByProjectId(int id);

    /**
     * 加入模块配置文件信息j
     * @param confInfo  配置文件信息
     * @param moduleId 计划单编号
     */
    public void addConfigInfo(ConfInfo confInfo,String moduleId);
    void updateProject(ProjectModel projectModel, int planStateBase);

    Users[] getUser(ProjectModel projectModel);

    Project getProject(ProjectModel projectModel);

    ProStateType getProjectState(int stateTypeId);
}
