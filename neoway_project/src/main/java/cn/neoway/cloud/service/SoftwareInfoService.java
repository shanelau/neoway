package cn.neoway.cloud.service;

import cn.neoway.cloud.bean.ConfInfo;
import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.common.service.IBaseService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-18
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
public interface SoftwareInfoService extends IBaseService<SoftwareInfo,Integer> {
    List<SoftwareInfo> getNullFileByTypeId();
}
