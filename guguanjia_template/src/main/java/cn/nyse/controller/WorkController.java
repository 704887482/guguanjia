package cn.nyse.controller;

import cn.nyse.service.WorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author hhy
 * @Date 2019/10/10 18:10
 */
@Controller
@RequestMapping("/manager")
public class WorkController {

    @Autowired
    WorkService service;

    @RequestMapping("/admin/work")
    public String work(){
        return "/work/admin/work";
    }

    @RequestMapping("/admin/toIndex")
    @ResponseBody
    public PageInfo<Map<String, Object>> toIndex(@RequestBody Map<String,Object> params){
        if(!params.containsKey("pageNum")|| StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if(!params.containsKey("pageSize")|| StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        //初始化分页插件
        PageHelper.startPage((Integer)params.get("pageNum"),(Integer)params.get("pageSize"));
        //查询list
        List<Map<String, Object>> maps = service.selectByCondition(params);
        PageInfo<Map<String, Object>> workPageInfo = new PageInfo<>(maps);
        return workPageInfo;
    }



    @RequestMapping(value = "/admin/work/detail/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> detail(@PathVariable("id") int id){
        return service.selectOneByCondition(id);
    }

    @RequestMapping(value = "/admin/work/print/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> print(@PathVariable("id") int id){
        return service.selectOneByCondition(id);
    }
}
