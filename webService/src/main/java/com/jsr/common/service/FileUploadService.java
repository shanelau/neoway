package com.jsr.common.service;

import com.jsr.common.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-19
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
@Component("FileUploadService")
public class FileUploadService {
    Logger logger = Logger.getLogger(FileUploadService.class.getName());
    @Autowired
    @Qualifier("multipartResolver")
    CommonsMultipartResolver multipartResolver;

    public Map addFileToDisk(HttpServletRequest request) {
        Map filesMap = new HashMap<String,String >();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        if (multipartResolver.isMultipart(multipartRequest)) {  //判断 request 是否有文件上传,即多部分请求...
            String logoPathDir = "upload" ;                     /** 构建文件保存的目录* */
            String logoRealPathDir = request.getSession().getServletContext()             /** 得到文件保存目录的真实路径* */
                    .getRealPath("")+File.separator+"WEB-INF"+File.separator+logoPathDir;

            MultiValueMap<String, MultipartFile> multfiles = multipartRequest.getMultiFileMap();              // srcfname 是指 文件上传标签的 name=值
            for (String srcfname : multfiles.keySet()) {
                String fileDirectory = mkDir(logoRealPathDir,srcfname);         //创建文件夹

                MultipartFile mfile = multfiles.getFirst(srcfname);
                try {
                    String originalFilename = mfile.getOriginalFilename();
                    if(originalFilename !=null && !originalFilename.equals("")){          //上传文件处不为空
                        String name =  originalFilename.substring(0,originalFilename.lastIndexOf("."));
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                        //String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
                        //                 /** 使用UUID生成文件名称* */
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssS");
                        String logImageName =  name+"-"+ sdf.format(new Date())+suffix;   //文件命名 加上时间
                        String fileName = fileDirectory + File.separator + logImageName;                       /** 拼成完整的文件保存路径加文件* */
                        mfile.transferTo(new File(fileName));
                        String relativePath =logoPathDir+File.separator+srcfname+File.separator+ logImageName; //相对路径
                        if(Constants.DEBUG_LOG){
                            logger.info(relativePath);
                            logger.error(fileName);
                        }

                        filesMap.put(srcfname,relativePath);
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return filesMap;
    }
    public String mkDir(String logoRealPathDir,String srcfname){
        logoRealPathDir =logoRealPathDir+File.separator+srcfname;
        File logoSaveFile = new File(logoRealPathDir);                               /** 根据真实路径创建目录* */
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        return logoRealPathDir;
    }
}
