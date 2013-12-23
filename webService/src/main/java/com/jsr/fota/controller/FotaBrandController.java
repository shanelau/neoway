package com.jsr.fota.controller;

import com.jsr.common.model.DataTableBean;
import com.jsr.common.pagination.Page;
import com.jsr.common.pagination.PageUtil;
import com.jsr.fota.bean.FotaBrand;
import com.jsr.fota.service.FotaBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-19
 * Time: 下午5:24
 * coding for fun and coding my life!
 */
@RequestMapping("/fota/brand")
@Controller
public class FotaBrandController {
    @Autowired
    @Qualifier("FotaBrandService")
    FotaBrandService fotaBrandService;

    @RequestMapping("/index")
    public String brandMangerIndex(){
        return "fota/brand";
    }
    @RequestMapping("/list")
    @ResponseBody
    public DataTableBean listBrand(HttpServletRequest request){
        int sEcho = ServletRequestUtils.getIntParameter(request, "sEcho", 0);
        //int pageSize = ServletRequestUtils.getIntParameter(request, "iDisplayLength", 10);
        List<FotaBrand> list = fotaBrandService.listAll();
        if(list != null){
            for(FotaBrand fotaBrand:list){
                fotaBrand.setFotaVersionsByBrandId(null);
            }
            Page<FotaBrand> page = PageUtil.getPage(list.size(), 0, list, list.size());
            return  new DataTableBean(page,sEcho);
        }
        return null;

    }

    @RequestMapping("/add")
    @ResponseBody
    public FotaBrand addBrand(String brandName,String oem,String product,String language){
        FotaBrand fotaBrand = new FotaBrand(brandName,oem,product,language);
        try {
            return fotaBrandService.save(fotaBrand);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/delete/{brandId}")
    @ResponseBody
    public Boolean deleteByBrandId(@PathVariable int brandId){
        try{
            fotaBrandService.delete(brandId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("/update")
    @ResponseBody
    public FotaBrand updateBrand(int brandId,String brandName,String oem,String product,String language){
        FotaBrand fotaBrand = new FotaBrand(brandId,brandName,oem,product,language);
        try {
            fotaBrandService.update(fotaBrand);
            return fotaBrand;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
