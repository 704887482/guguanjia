package cn.nyse.controller;

import cn.nyse.service.QualificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/manager/qualification")
public class QualificationController {

    @Autowired
    QualificationService service;

    @RequestMapping("index")
    public String index(){
        return "/qualification/index";
    }


    @RequestMapping("toIndex")
    @ResponseBody
    public PageInfo<Map<String, Object>> toIndex(@RequestBody Map<String,Object> params){
        if(!params.containsKey("pageNum")|| StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if(!params.containsKey("pageSize")|| StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer)params.get("pageNum"),(Integer)params.get("pageSize"))  ;
        return  new PageInfo<Map<String,Object>>(service.selectByCondition(params));
    }
}
