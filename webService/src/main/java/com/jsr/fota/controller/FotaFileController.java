package com.jsr.fota.controller;

import com.jsr.common.model.DataTableBean;
import com.jsr.common.pagination.Page;
import com.jsr.common.pagination.PageUtil;
import com.jsr.fota.FotaConstants;
import com.jsr.fota.bean.FotaBrand;
import com.jsr.fota.bean.FotaFile;
import com.jsr.fota.bean.FotaVersion;
import com.jsr.fota.service.FileUploadToBcsService;
import com.jsr.fota.service.FotaBrandService;
import com.jsr.fota.service.FotaFileService;
import com.jsr.fota.service.FotaVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-24
 * Time: 上午9:37
 * coding for fun and coding my life!
 */
@RequestMapping("/fota/file")
@Controller
public class FotaFileController {
    @Autowired
    @Qualifier("FotaVersionService")
    FotaVersionService fotaVersionService;

    @Autowired
    @Qualifier("FotaBrandService")
    FotaBrandService fotaBrandService;

    @Autowired
    @Qualifier("FotaFileService")
    FotaFileService fotaFileService;

    @Autowired
    @Qualifier("FileUploadToBcsService")
    FileUploadToBcsService fileUploadToBcsService;


    @RequestMapping("/index/{versionId}")
    public ModelAndView index(@PathVariable int versionId){
        ModelAndView model = new ModelAndView("fota/versionUpload");
        FotaVersion fotaVersion = fotaVersionService.get(versionId);
        model.addObject("fotaVersion",fotaVersion);
        return model;
    }
    @RequestMapping("/list/{versionId}")
    @ResponseBody
    public DataTableBean  listCanUpdate(@PathVariable int versionId,HttpServletRequest request){
        int sEcho = ServletRequestUtils.getIntParameter(request, "sEcho", 0);
        List<FotaFile> list = fotaFileService.listUpdateTo(versionId);
        for(FotaFile fotaFile :list){
            filter(fotaFile);
        }
        Page<FotaFile> page = PageUtil.getPage(list.size(), 0, list, list.size());
        return  new DataTableBean(page,sEcho);
    }

    private void filter(FotaFile fotaFile) {
        FotaVersion version = fotaFile.getFotaVersionByVersionId();
        version.setFotaBrandByBrandId(null);
        version.setFotaFilesByVersionId(null);
    }
    @RequestMapping("/add")
    @ResponseBody
    public Map add(HttpServletRequest request){
        int startVersionId = ServletRequestUtils.getIntParameter(request,"startVersionId",-1);
        int versionId = ServletRequestUtils.getIntParameter(request,"versionId",-1);
        if(versionId == -1 || startVersionId ==-1){
            return FotaConstants.getMessage(false,"id not exist!");
        }
        try{
            FotaFile mFotaFile = fotaFileService.getByFileIdAndToId(startVersionId,versionId);
            if(mFotaFile != null){                //不能存在重复的升级包
                return FotaConstants.getMessage(false,"相同的升级版本已经存在!");
            }
            FotaVersion version = fotaVersionService.get(startVersionId);
            Map<String,String> map = fileUploadToBcsService.uploadToBcs(request,version.getVersionName());
            if(map != null){
                FotaFile fotaFile = new FotaFile();
                fotaFile.setFotaVersionByVersionId(version);
                fotaFile.setUpdateTo(versionId);
                fotaFile.setSize(map.get("filesize"));
                fotaFile.setUrl(map.get("url"));
                fotaFile.setFileName(map.get("filename"));
                fotaFile.setBcsObject(map.get("obj"));
                fotaFile.setFileDate(new Timestamp(System.currentTimeMillis()));
                FotaFile fotaFile2 = fotaFileService.save(fotaFile);
                filter(fotaFile2);
                return FotaConstants.getMessage(true,fotaFile2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return FotaConstants.getMessage(false,"It happend some exception!");
    }
    @RequestMapping("/delete/{fileId}")
    @ResponseBody
    public Boolean deleteByBrandId(@PathVariable int fileId){
        try{
            fotaFileService.delete(fileId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("/send/{fileId}")
    @ResponseBody
    public Boolean sendToUpdate(@PathVariable int fileId,String range){
        FotaFile fotaFile = fotaFileService.get(fileId);
        if(fotaFile == null){
            return false;
        }
        List<String> imeis =null;
        return fotaFileService.pushToPhone(fotaFile,imeis);
    }

}
