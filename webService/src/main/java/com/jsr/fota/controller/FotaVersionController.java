package com.jsr.fota.controller;

import com.jsr.common.model.DataTableBean;
import com.jsr.common.pagination.Page;
import com.jsr.common.pagination.PageUtil;
import com.jsr.feedback.FeedBackConstants;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.model.FBQueryModel;
import com.jsr.fota.bean.FotaBrand;
import com.jsr.fota.bean.FotaVersion;
import com.jsr.fota.model.FotaVersionQueryModel;
import com.jsr.fota.service.FotaBrandService;
import com.jsr.fota.service.FotaVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-23
 * Time: 上午9:24
 * coding for fun and coding my life!
 */
@RequestMapping("/fota/version")
@Controller
public class FotaVersionController {
    @Autowired
    @Qualifier("FotaVersionService")
    FotaVersionService fotaVersionService;

    @Autowired
    @Qualifier("FotaBrandService")
    FotaBrandService fotaBrandService;

    @RequestMapping("/index")
    public String indexVersion(){
        return "fota/version";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataTableBean list(HttpServletRequest request){
        int startNum = ServletRequestUtils.getIntParameter(request, "iDisplayStart", 0);
        int sEcho = ServletRequestUtils.getIntParameter(request, "sEcho", 0);
        int pageSize = ServletRequestUtils.getIntParameter(request, "iDisplayLength", 10);
        String order = ServletRequestUtils.getStringParameter(request, "sSortDir_0","desc");
        String search = ServletRequestUtils.getStringParameter(request, "sSearch","");             //查询关键字
        FotaVersionQueryModel fvModel = new FotaVersionQueryModel(search,order);

        int pn = startNum/pageSize+1;
        Page<FotaVersion> page = fotaVersionService.list(pn, pageSize, fvModel);
        for(FotaVersion fotaVersion:page.getItems()){
            jsonFilter(fotaVersion);
        }
        return new DataTableBean(page,sEcho);
    }


    public FotaVersion jsonFilter(FotaVersion fotaVersion){
        fotaVersion.setFotaFilesByVersionId(null);
        fotaVersion.getFotaBrandByBrandId().setFotaVersionsByBrandId(null);
        return fotaVersion;
    }
    @RequestMapping("/add")
    @ResponseBody
    public FotaVersion add(Integer brandId,String versionName,String versionDesc){
        FotaBrand fotaBrand = fotaBrandService.get(brandId);
        FotaVersion  fotaVersion= new FotaVersion();
        fotaVersion.setVersionName(versionName);
        fotaVersion.setVersionDesc(versionDesc);
        fotaVersion.setFotaBrandByBrandId(fotaBrand);
        fotaVersion.setVersionDate(new Timestamp(System.currentTimeMillis()));
        try{
            return jsonFilter(fotaVersionService.save(fotaVersion));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/update")
    @ResponseBody
    public FotaVersion update(Integer versionId,Integer brandId,String versionName,String versionDesc){
        FotaBrand fotaBrand = fotaBrandService.get(brandId);
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FotaVersion fotaVersion = new FotaVersion(versionId,fotaBrand,versionName,versionDesc);
        try {
            fotaVersionService.update(fotaVersion);
            return jsonFilter(fotaVersion);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/delete/{versionId}")
    @ResponseBody
    public Boolean delete(@PathVariable int versionId){
        try{
            fotaVersionService.delete(versionId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
