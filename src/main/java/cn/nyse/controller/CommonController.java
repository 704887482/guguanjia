package cn.nyse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/common")
public class CommonController {

    @RequestMapping("navbar")
    public String navbar(){
        return "/common/navbar";
    }

    @RequestMapping("sidebar")
    public String sidebar(){
        return "/common/sidebar";
    }

    @RequestMapping("aceSetting")
    public String aceSetting(){
        return "/common/aceSetting";
    }
}
