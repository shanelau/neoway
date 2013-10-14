package cn.neoway.cloud.controller.file;


import cn.neoway.cloud.bean.SoftwareInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-22
 * Time: 下午2:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FileUpload {
    @Autowired
    CommonsMultipartResolver multipartResolver;

    @RequestMapping(value = "/config_upload", method = RequestMethod.POST)
    public String addCategory(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        if (multipartResolver.isMultipart(multipartRequest)) {  //判断 request 是否有文件上传,即多部分请求...
            String logoPathDir = "upload_temp/module/" ;                     /** 构建文件保存的目录* */
            String logoRealPathDir = request.getSession().getServletContext()             /** 得到文件保存目录的真实路径* */
                    .getRealPath(logoPathDir);
            File logoSaveFile = new File(logoRealPathDir);                               /** 根据真实路径创建目录* */
            if (!logoSaveFile.exists())
                logoSaveFile.mkdirs();

            System.out.print(logoSaveFile.getAbsolutePath());
            MultiValueMap<String, MultipartFile> multfiles = multipartRequest.getMultiFileMap();              // srcfname 是指 文件上传标签的 name=值
            for (String srcfname : multfiles.keySet()) {
                MultipartFile mfile = multfiles.getFirst(srcfname);
                try {
                    String suffix = mfile.getOriginalFilename().substring(mfile.getOriginalFilename().lastIndexOf("."));
                    String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称                   /** 使用UUID生成文件名称* */
                    String fileName = logoRealPathDir + File.separator + logImageName;                       /** 拼成完整的文件保存路径加文件* */
                    File file = new File(fileName);
                    mfile.transferTo(file);


                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "login";
    }

    @RequestMapping(value = "/file/upload", method = RequestMethod.GET)
    public String upload() {
        return "file/upload";
    }
    @RequestMapping(value = "/file/jsonTest" ,method = RequestMethod.GET)
    public ModelAndView queryAppliesForJson(HttpServletRequest request) {
        String str = request.getParameter("tag");
        System.out.print(str);
        ModelAndView mav = new ModelAndView("file/upload");
        List applyList = new ArrayList();
        applyList.add(1);
        applyList.add(2);
        mav.addObject("applyList", applyList);
        return mav;
    }
}
