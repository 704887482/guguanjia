package cn.nyse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/demand")
public class DemandController {


    @RequestMapping("index")
    public String index(){
        return "/demand/index";
    }
}
