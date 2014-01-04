package com.jsr.fota.controller;

import com.jsr.common.model.DataTableBean;
import com.jsr.common.pagination.Page;
import com.jsr.common.pagination.PageUtil;
import com.jsr.fota.bean.FotaBrand;
import com.jsr.fota.bean.FotaImei;
import com.jsr.fota.service.FotaImeiService;
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
 * Date: 13-12-25
 * Time: 下午4:43
 * coding for fun and coding my life!
 */
@RequestMapping("/fota/imei")
@Controller
public class FotaImeiController {
    @Autowired
    @Qualifier("FotaImeiService")
    FotaImeiService fotaImeiService;
    @RequestMapping("/index")
    public String index(){
        return "fota/imei";
    }
    @RequestMapping("/add")
    @ResponseBody
    public FotaImei add(String imei){
        String[] imeis;
        try {
            if(imei.contains(",")){
                imeis = imei.split(",");
                for(String Imei:imeis){
                    fotaImeiService.save(new FotaImei(Imei));
                }
                return null;
            }else{
                return fotaImeiService.save(new FotaImei(imei));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/delete/{imei}")
    @ResponseBody
    public Boolean deleteByBrandId(@PathVariable String imei){
        try{
            fotaImeiService.delete(imei);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("/list")
    @ResponseBody
    public DataTableBean listBrand(HttpServletRequest request){
        int sEcho = ServletRequestUtils.getIntParameter(request, "sEcho", 0);
        List<FotaImei> list = fotaImeiService.listAll();
        Page<FotaImei> page = PageUtil.getPage(list.size(), 0, list, list.size());
        return  new DataTableBean(page,sEcho);
    }
}
