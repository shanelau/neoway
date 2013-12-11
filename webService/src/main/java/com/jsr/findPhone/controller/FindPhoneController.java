package com.jsr.findPhone.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsr.findPhone.FindPhoneConstants;
import com.jsr.findPhone.bean.PhoneInfo;
import com.jsr.findPhone.bean.PhoneLog;
import com.jsr.findPhone.service.PhoneInfoService;
import com.jsr.findPhone.service.PhoneLogService;
import com.jsr.pushclient.PushManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-5
 * Time: 下午4:10
 * coding for fun and coding my life!
 */
@Controller
@RequestMapping(value = "/findphone")
public class FindPhoneController {
    @Autowired
    @Qualifier("PhoneInfoService")
    PhoneInfoService phoneInfoService;

    @Autowired
    @Qualifier("PhoneLogService")
    PhoneLogService phoneLogService;

    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView model = new ModelAndView("findphone/index");
        Subject  subject = SecurityUtils.getSubject();
        List<PhoneInfo> list = phoneInfoService.getByUsername(subject.getPrincipal().toString());
        model.addObject("phoneList",list);
        return model;
    }

    /**
     * 如果没有绑定，则提示绑定
     * 如果用户绑定了有多个手机,则进行选择
     * @return
     */
    @RequestMapping(value = "/getAllPhone")
    @ResponseBody
    public Map choosePhone(){
        Subject  subject = SecurityUtils.getSubject();
        List<PhoneInfo> list = phoneInfoService.getByUsername(subject.getPrincipal().toString());
        if(list == null || list.size()==0){
            return  FindPhoneConstants.getMessage(false,"没有绑定一个手机");
        }else{
            for(PhoneInfo phoneInfo:list){
                phoneInfo.setUsersByUserId(null);
                phoneInfo.setPhoneLogsByPhId(null);
            }
            return FindPhoneConstants.getMessage(true,list);
        }
    }

    /**
     *
     * @param request
     * @return   返回当前用户默认的设备
     */
    private PhoneInfo getDefaultDevice(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object phoneInfo = session.getAttribute("defaultDevice");
        if(phoneInfo != null && phoneInfo instanceof PhoneInfo){
            return (PhoneInfo)phoneInfo;
        }
        return null;
    }

    /**
     *  获取系统当前操作的device
     * @param request
     * @return
     */
    @RequestMapping(value = "/setDefaultDevice")
    @ResponseBody
    public Boolean bingPhone(HttpServletRequest request,String imei){
        PhoneInfo phoneInfo = phoneInfoService.getByImei(imei);
        if(phoneInfo != null){
            request.getSession().setAttribute("defaultDevice",phoneInfo);
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/update_location")
    public String updateLocation(){
        return "findphone/update_location";
    }

    @RequestMapping(value = "/get_by_imei")
    @ResponseBody
    public PhoneInfo getPhoneByImei(String imei ){
        PhoneInfo phoneInfo = phoneInfoService.getByImei(imei);
        phoneInfo.setPhoneLogsByPhId(null);
        phoneInfo.setUsersByUserId(null);
        return phoneInfo;
    }
    @RequestMapping(value = "/getlocation")
    @ResponseBody
    public Map getLocation(String imei ){
        return getResult(imei,FindPhoneConstants.LOCATION,"",FindPhoneConstants.LOCATION_Expiry_Date,FindPhoneConstants.PUSH_LOCATION_ITERVAL);
    }
    /**
     * 判断该log是否过期
     * @param phoneLog      位置信息
     * @return    ture 过期  false 未过期
     */
    private boolean outDate(PhoneLog phoneLog,long addTime) {
        long lastUpdateTime =phoneLog.getLogTime().getTime()+addTime;
        if( lastUpdateTime < System.currentTimeMillis()){     //如果小于当前时间，过期了
            return true;
        }
        return false;
    }
    /**
     * @param imei      imei号
     * @param isopen    发出声响状态 {true,false}
     * @return
     */
    @RequestMapping(value = "/voice")
    @ResponseBody
    public Map makeVoice(String imei,String isopen){
        return getResult(imei,FindPhoneConstants.VOICE,isopen,FindPhoneConstants.LOCATION_Expiry_Date,FindPhoneConstants.PUSH_LOCATION_ITERVAL);
    }

    @RequestMapping(value = "/lock")
    @ResponseBody
    public Map clock(String imei,String isopen){
        return getResult(imei,FindPhoneConstants.LOCK,isopen,FindPhoneConstants.LOCATION_Expiry_Date,FindPhoneConstants.PUSH_LOCATION_ITERVAL);
    }

    @RequestMapping(value = "/update_location",method = RequestMethod.POST)
    @ResponseBody
    public Map updateLocation(HttpServletRequest request ){
        String imei = ServletRequestUtils.getStringParameter(request,"imei","");
        String pointX = ServletRequestUtils.getStringParameter(request,"pointX","");
        String pointY = ServletRequestUtils.getStringParameter(request,"pointY","");

        PhoneInfo phoneInfo = phoneInfoService.getByImei(imei);
        if(phoneInfo == null)
            return FindPhoneConstants.getMessage(false,"imei not found!");

        PhoneLog phoneLog = new PhoneLog();
        phoneLog.setPointX(pointX);
        phoneLog.setPointY(pointY);
        phoneLog.setLogTime(new Timestamp(System.currentTimeMillis()));
        phoneLog.setClient(true);
        phoneLog.setName("location");
        phoneLog.setPhoneInfoByPhId(phoneInfo);

        try{
            phoneLogService.save(phoneLog);
            return FindPhoneConstants.getMessage(true,"update success");
        }catch (Exception e){
             e.printStackTrace();
            return FindPhoneConstants.getMessage(false,"update fail");
        }
    }
    public Map getResult(String imei ,String motion,String value,long expiryDate,long pushExpiryDate){
        PhoneLog phoneLog = phoneLogService.getTopByImei(imei,motion ,true); //获取客户端发送的最新状态信息
        if(phoneLog == null){        //是否存在一条记录
            return canPush(imei,motion,pushExpiryDate,value);
        }else{
            try {
                boolean outDate = outDate(phoneLog, expiryDate);
                if(outDate){   //motion信息过期
                    return canPush(imei,motion,pushExpiryDate,value);
                }else{
                    phoneLog.setPhoneInfoByPhId(null);
                    return  FindPhoneConstants.getMessage(true,phoneLog);
                }
            }catch (Exception e) {
                e.printStackTrace();
                return  FindPhoneConstants.getMessage(false,"maybe imei not found!");
            }
        }
    }

    /**
     *   服务器端是否执行push 指令的操作
     * @param imei       imei NO
     * @param motion   执行的动作  locaition voice lock
     * @param pushExpiryDate    同一个指令，服务器推送的间隔
     * @param value 指令 对应的值
     * @return       结果map
     */
    public Map canPush(String imei,String motion,long pushExpiryDate ,String value) {
        PhoneLog  pushLocationLog = phoneLogService.getTopByImei(imei,motion,false); //push log信息
        if(pushLocationLog == null){         //是否已经发送push
            return  pushMotion(imei, motion, value, "push success,please wait");
        }else{
            boolean pushOutDate = outDate(pushLocationLog,pushExpiryDate);
            if(pushOutDate){    //push 是否过期
                return  pushMotion(imei, motion, value, "push success,please wait");
            }else {
                return FindPhoneConstants.getMessage(false,"The Server is located your phone,please wait for a few minutes!");
            }
        }
    }
    public Map pushMotion(String imei, String motion, String value, Object obj){
        PhoneInfo phoneInfo = phoneInfoService.getByImei(imei);
        if(phoneInfo == null)
            return FindPhoneConstants.getMessage(false,"imei not found!");

        PhoneLog phoneLog = new PhoneLog();
        phoneLog.setName(motion);
        phoneLog.setLogTime(new Timestamp(System.currentTimeMillis()));
        phoneLog.setClient(false); //服务器端发出的定位操作
        phoneLog.setContent(value);
        phoneLog.setPhoneInfoByPhId(phoneInfo);
        phoneLogService.save(phoneLog);
        String message = null;
        try {
            message = FindPhoneConstants.getPushMap(FindPhoneConstants.FIND_PHONE_PACKAGE, motion);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        PushManager.getInstance().sendMessage(FindPhoneConstants.PUSH_FROM,phoneInfo.getImeiNo(),message);
        return FindPhoneConstants.getMessage(false,obj);
    }
}
