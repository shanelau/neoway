package com.jsr.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
