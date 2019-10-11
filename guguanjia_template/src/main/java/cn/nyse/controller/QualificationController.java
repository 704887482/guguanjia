package cn.nyse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author hhy
 * @Date 2019/10/11 19:53
 */
@Controller
@RequestMapping("/manager/qualification")
public class QualificationController {

    @RequestMapping("index")
    public String index(){
        return "/qualification/index";
    }
}
