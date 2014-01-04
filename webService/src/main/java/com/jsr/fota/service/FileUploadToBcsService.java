package com.jsr.fota.service;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.auth.BCSSignCondition;
import com.baidu.inf.iis.bcs.http.HttpMethodName;
import com.baidu.inf.iis.bcs.model.ObjectMetadata;
import com.baidu.inf.iis.bcs.request.GenerateUrlRequest;
import com.baidu.inf.iis.bcs.request.PutObjectRequest;
import com.jsr.common.service.FileUploadService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-24
 * Time: 下午4:50
 * coding for fun and coding my life!
 */
@Component("FileUploadToBcsService")
public class FileUploadToBcsService {
    Logger logger = Logger.getLogger(FileUploadService.class.getName());
    @Autowired
    @Qualifier("multipartResolver")
    CommonsMultipartResolver multipartResolver;
    SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssS");

    static String host = "bcs.duapp.com";
    static String accessKey = "yhuTU4WqlgM08szDNpAtw8k4";
    static String secretKey = "RTOFR6L7uUFpbGmrR6W4yB9Em8fK3bwj";
    static String bucket = "innosrom";
    final String BCS_PATH = "/FOTA/";

    public Map uploadToBcs(HttpServletRequest request, String versionName){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        if (multipartResolver.isMultipart(multipartRequest)) {
            MultiValueMap<String, MultipartFile> multfiles = multipartRequest.getMultiFileMap();
            MultipartFile multfile = multfiles.getFirst("fileName");
            String filename = getFileNmae(multfile.getOriginalFilename());
            logger.info(filename);
            try {
                String obj = BCS_PATH+versionName+"/"+filename;  //存储对象名
                String url = putObjectByInputStream(multfile,obj);
                Map map = new HashMap<String,String>();
                map.put("filename",filename);
                map.put("url",url);
                map.put("filesize",FileUtils.byteCountToDisplaySize(multfile.getSize()));
                map.put("obj",obj);
                return map;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    private String getFileNmae(String originalFilename) {
        if(originalFilename !=null && !originalFilename.equals("")){
            String name =  originalFilename.substring(0,originalFilename.lastIndexOf("."));
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            return name+"-"+sdf.format(new Date())+suffix;
        }
        return "";
    }

    public String putObjectByInputStream(MultipartFile multfile,String name) throws IOException {
        BaiduBCS baiduBCS = upToBCSInit();//初始化
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("application/zip");
        objectMetadata.setContentDisposition("attachement");
        objectMetadata.setContentLength(multfile.getSize());
        PutObjectRequest request = new PutObjectRequest(bucket, name, multfile.getInputStream(), objectMetadata);
        ObjectMetadata result = baiduBCS.putObject(request).getResult();
        logger.info(result);

        return generateUrl(baiduBCS,name);         //生成url
    }
    public BaiduBCS upToBCSInit(){
        BCSCredentials credentials = new BCSCredentials(accessKey, secretKey);
        BaiduBCS baiduBCS = new BaiduBCS(credentials, host);
        baiduBCS.setDefaultEncoding("UTF-8");
        return baiduBCS;
    }
    /*生成可以访问的url
    *
    * */
   public String generateUrl(BaiduBCS baiduBCS,String object) {
        GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, bucket, object);
        generateUrlRequest.setBcsSignCondition(new BCSSignCondition());
        generateUrlRequest.getBcsSignCondition().setIp("*");
        String url = baiduBCS.generateUrl(generateUrlRequest);
        logger.info(url);
        return url;
    }

}
