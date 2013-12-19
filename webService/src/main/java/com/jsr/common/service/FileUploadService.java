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
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

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
    String logImageName;
    String fileName;
    SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssS");

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
                        initFileName(mfile,fileDirectory, name, suffix);//初始化文件名和路径
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

    /**
     * 初始化文件名,保存到相对路径
     * @param mfile 上传的文件流
     * @param fileDirectory 需要保存的绝对路径
     * @param name 文件名
     * @param suffix 文件后缀
     * @throws IOException
     */
    public void initFileName(MultipartFile mfile,String fileDirectory,String name,String suffix) throws IOException {
        boolean gz = suffix.equals(".gz");
        logImageName = gz?(name+"-"+ sdf.format(new Date())+".txt"):(name+"-"+ sdf.format(new Date())+suffix);
        fileName = fileDirectory + File.separator + logImageName;  /** 拼成完整的文件保存路径加文件* */
        if(gz){
            saveGZ(mfile,fileName);
        }else {
            mfile.transferTo(new File(fileName));
        }
    }

    /**
     * 有些上传的文件时gz格式，需要解压后保存
     * @param mfile    上传的文件流
     * @param fileName 保存的文件相路径
     */
    private void saveGZ(MultipartFile mfile,String fileName) {
        {
            try {
                GZIPInputStream in = new GZIPInputStream(mfile.getInputStream());
                OutputStream out = new FileOutputStream(fileName);
                // Transfer bytes from the compressed file to the output file
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                // Close the file and stream
                in.close();
                out.close();
            } catch (IOException e) {
            }
        }
    }

    public String mkDir(String logoRealPathDir,String srcfname){
        logoRealPathDir =logoRealPathDir+File.separator+srcfname;
        File logoSaveFile = new File(logoRealPathDir);                               /** 根据真实路径创建目录* */
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        return logoRealPathDir;
    }
}
