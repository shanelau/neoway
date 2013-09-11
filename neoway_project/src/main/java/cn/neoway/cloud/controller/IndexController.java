package cn.neoway.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Zhangkaitao
 * @version 1.0
 */
@Controller("indexController")
public class IndexController {
    
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request){
        return "index";
    }

}
