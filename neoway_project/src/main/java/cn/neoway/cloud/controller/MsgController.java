package cn.neoway.cloud.controller;

import cn.neoway.cloud.bean.SysEmail;
import cn.neoway.cloud.service.SysEmailService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-8
 * Time: 上午8:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MsgController {
    @Autowired
    @Qualifier("SysEmailService")
    SysEmailService sysEmailService;

    @RequestMapping(value = "/user_advice",method = {RequestMethod.POST,RequestMethod.GET})
    public void saveMsg(HttpServletRequest request,HttpServletResponse response){
        String msg_advice = request.getParameter("msg_advice");
        SysEmail sysEmail = new SysEmail();
        sysEmail.setEmailTitle("advice");
        sysEmail.setSendTo("sys");
        sysEmail.setContent(msg_advice);
        sysEmail.setSendTime(new Timestamp(System.currentTimeMillis()));
        int valid = 1;
        String msg = "谢谢您的支持，我们会继续努力！";
        try{
            sysEmailService.save(sysEmail);
        }catch (Exception e){
            e.printStackTrace();
            valid = 0;
            msg = "好像出了点问题，我们会尽快修复";
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("valid", valid);
        map.put("message", msg);
        try {
            PrintWriter out = response.getWriter();
            out.write(JSONObject.fromObject(map).toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    @RequestMapping(value = "/msg/delete")
    public String deleteMsg(HttpServletRequest request){
        String msg_id = request.getParameter("msg_id");
        int id = Integer.parseInt(msg_id);
        try{
            sysEmailService.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/advice_list";
    }
    @RequestMapping(value = "/advice_list")
    public ModelAndView listMsg(){
        ModelAndView model = new ModelAndView("advice_list");
        List<SysEmail> adviceList =  sysEmailService.listAll();
        model.addObject("adviceList",adviceList);
        return model;
    }
}
