package com.jsr.feedback.controller;

import com.jsr.common.model.DataTableBean;
import com.jsr.common.pagination.Page;
import com.jsr.common.service.FileUploadService;
import com.jsr.feedback.FeedBackConstants;
import com.jsr.feedback.model.FBQueryModel;
import com.jsr.feedback.bean.FbFeedbacks;
import com.jsr.feedback.bean.FbStatu;
import com.jsr.feedback.bean.FbType;
import com.jsr.feedback.service.FbFeedbacksService;
import com.jsr.feedback.service.FbStatuService;
import com.jsr.feedback.service.FbTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-20
 * Time: 上午9:05
 * coding for fun and coding my life!
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    Logger logger = Logger.getLogger(FileUploadService.class.getName());
    @Autowired
    @Qualifier("FbFeedbacksService")
    FbFeedbacksService fbFeedbacksService;
    @Autowired
    @Qualifier("FbTypeService")
    FbTypeService fbTypeService;
    @Autowired
    @Qualifier("FbStatuService")
    FbStatuService fbStatuService;
    @Autowired
    @Qualifier("FileUploadService")
    FileUploadService fileUploadService;

    @RequestMapping(value="/index")
    public ModelAndView feedbackIndex(){
        ModelAndView model = new ModelAndView("feedback/index");
        List<FbStatu> statusList = fbStatuService.listAll();
        List<FbType> typeList = fbTypeService.listAll();
        for(FbStatu fbStatu:statusList){
            fbStatu.setFbFeedbacksesByStatusId(null);
        }
        for(FbType fbType:typeList){
            fbType.setFbFeedbacksesByTypeId(null);
        }
        model.addObject("statusList",statusList);
        model.addObject("typeList",typeList);
        return model;
    }

    @RequestMapping(value="/add")
    public ModelAndView addFeedbackController(){
        ModelAndView model = new ModelAndView("feedback/add");
        List<FbType> typeList = fbTypeService.listAll();
        model.addObject("typeList",typeList);
        return model;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Map addFeedbackController(HttpServletRequest request) {
        FbFeedbacks fbFeedbacks = new FbFeedbacks();
        fbFeedbacks.setContent(request.getParameter("content"));
        fbFeedbacks.setVersion(request.getParameter("version"));
        fbFeedbacks.setPhImei(request.getParameter("phImei"));
        fbFeedbacks.setContact(request.getParameter("contact"));

        String _typeId = request.getParameter("typeId");
        if(_typeId!=null){
            int typeId = Integer.parseInt(_typeId);
            FbType fbType = fbTypeService.get(typeId);
            fbFeedbacks.setFbTypeByTypeId(fbType);
        }
        fbFeedbacks.setFbDate(new Timestamp(System.currentTimeMillis()));
        FbStatu fbStatu = fbStatuService.get(FeedBackConstants.FEEDBACK_STATUS_NEW);
        fbFeedbacks.setFbStatuByStatusId(fbStatu);
        try{
            Map<String,String> map = fileUploadService.addFileToDisk(request);
            fbFeedbacks = packFilePath(map,fbFeedbacks);
            FbFeedbacks fb = fbFeedbacksService.save(fbFeedbacks);
            if(fb != null){
                return getResutl(FeedBackConstants.RESPONSE_MESSAGE_SUCCESS,FeedBackConstants.STATUS_SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getResutl(FeedBackConstants.RESPONSE_MESSAGE_FAIL,FeedBackConstants.STATUS_FAIL);
    }
    public Map getResutl(String[] strs,String status){
        Map map = new HashMap();
        map.put(FeedBackConstants.TAG_STATUS, status);
        int random = (int)(Math.random()* strs.length);
        map.put(FeedBackConstants.TAG_MESSAGE, strs[random]);
        return map;
    }

    /**
     * @param map  key  文件类型（log, img） value ：文件路径
     * @param fbFeedbacks   反馈对象
     * @return   设置好文件路径的对象
     */
    private FbFeedbacks packFilePath(Map<String,String> map, FbFeedbacks fbFeedbacks) {
        for(String key :map.keySet()){
            String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
            try {
                Method method = fbFeedbacks.getClass().getMethod(methodName, String.class);
                method.invoke(fbFeedbacks, map.get(key));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return fbFeedbacks;
    }
    @RequestMapping(value = "/list")
    @ResponseBody
    public DataTableBean getPage(HttpServletRequest request,HttpServletResponse response){
        int startNum = ServletRequestUtils.getIntParameter(request, "iDisplayStart", 0);
        int sEcho = ServletRequestUtils.getIntParameter(request, "sEcho", 0);
        int pageSize = ServletRequestUtils.getIntParameter(request, "iDisplayLength", FeedBackConstants.DEFAULT_PAGE_SIZE);
        String order = ServletRequestUtils.getStringParameter(request, "sSortDir_0","desc");
        String search = ServletRequestUtils.getStringParameter(request, "sSearch","");             //查询关键字
        String type = ServletRequestUtils.getStringParameter(request, "sSearch_0","");           //类别
        String status = ServletRequestUtils.getStringParameter(request, "sSearch_1",""); //状态
        FBQueryModel fbQueryModel = new FBQueryModel(search,type,status,order);

        int pn = startNum/pageSize+1;
        Page<FbFeedbacks> page = fbFeedbacksService.list(pn, pageSize, fbQueryModel);
        //response.addHeader("Access-Control-Allow-Origin","*");  //同源请求
        return new DataTableBean(page,sEcho);
    }

}
