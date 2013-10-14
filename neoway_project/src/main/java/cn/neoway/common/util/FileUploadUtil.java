package cn.neoway.common.util;

import cn.neoway.cloud.bean.SoftwareInfo;
import cn.neoway.cloud.bean.SoftwareType;
import cn.neoway.cloud.service.SoftwareInfoService;
import cn.neoway.cloud.service.SoftwareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-24
 * Time: 下午1:54
 * To change this template use File | Settings | File Templates.
 */
public class FileUploadUtil {


    public SoftwareInfo upLoad(int typeId,MultipartHttpServletRequest multipartRequest,CommonsMultipartResolver multipartResolver){
        MultipartHttpServletRequest request = multipartRequest;
        if (multipartResolver.isMultipart(multipartRequest)) {  //判断 request 是否有文件上传,即多部分请求...
            String logoPathDir = "upload_temp/"+typeId+"/" ;                     /** 构建文件保存的目录* */

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
                 //   String suffix = mfile.getOriginalFilename().substring(mfile.getOriginalFilename().lastIndexOf("."));
                    //String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称                   /** 使用UUID生成文件名称* */
                    String logImageName = mfile.getOriginalFilename();// 构建文件名称
                    String fileName = logoRealPathDir + File.separator + logImageName;                       /** 拼成完整的文件保存路径加文件* */
                    File file = new File(fileName);
                    mfile.transferTo(file);
                    SoftwareInfo softwareInfo = new SoftwareInfo();
                    softwareInfo.setSoftName(mfile.getOriginalFilename());
                    softwareInfo.setDate(new Timestamp(System.currentTimeMillis()));
                    softwareInfo.setSoftwarePath(logoPathDir+logImageName);
                    return softwareInfo;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public String[] uploadConfig(MultipartHttpServletRequest request,CommonsMultipartResolver multipartResolver){
        String[] filename = {"",""};
        MultipartHttpServletRequest multipartRequest = request;
        if (multipartResolver.isMultipart(multipartRequest)) {  //判断 request 是否有文件上传,即多部分请求...
            String logoPathDir = "upload_temp/config/" ;                     /** 构建文件保存的目录* */
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
                    //String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称                   /** 使用UUID生成文件名称* */
                    String logImageName = mfile.getOriginalFilename();// 构建文件名称
                    String fileName = logoRealPathDir + File.separator + logImageName;                       /** 拼成完整的文件保存路径加文件* */
                    File file = new File(fileName);
                    mfile.transferTo(file);
                    filename[0] =  mfile.getOriginalFilename();
                    filename[1] =  logoPathDir+logImageName;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return filename;
    }
}
