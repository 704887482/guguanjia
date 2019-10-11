package cn.nyse.controller;


import cn.nyse.entity.AppVersion;
import cn.nyse.service.AppVersionService;
import cn.nyse.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manager/app")
public class AppVersionController {


    @Autowired
    AppVersionService service;



    /*@RequestMapping("index")
    @ResponseBody
    public List<AppVersion> list(){
        return service.selectAll();
    }*/

    @RequestMapping("toIndex")
    @ResponseBody
    public PageInfo<AppVersion> list(@RequestParam(defaultValue = "1",name = "pageNum") int pageNum,@RequestParam(defaultValue = "5",name = "pageSize") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AppVersion> appVersions = service.selectAll();
        PageInfo<AppVersion> pageInfo = new PageInfo<>(appVersions);
        return pageInfo;
    }

   /* @RequestMapping("toList")
    public String toList(){
        return "/app_list";
    }*/


    @RequestMapping("index")
    public String toIndex(){
        return "/app/index";
    }

/*
* 根据id查询对象*/
    @RequestMapping("selectById")
    @ResponseBody
    public AppVersion selectById(@RequestParam("id") int id){
        return service.selectByPrimaryKey(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody  AppVersion appVersion){
        int i = service.updateByPrimaryKeySelective(appVersion);
        Result result = new Result();
        if(i>0){
            result.setSuccess(true);
            result.setMsg("更新成功");
        }else{
            result.setSuccess(false);
            result.setMsg("更新失败");
        }
        return result;
    }


    @RequestMapping("delete")
    @ResponseBody
    public Result delete(@RequestParam("id") int id){
        int i = service.deleteByPrimaryKey(id);
        Result result = new Result();
        if(i>0){
            result.setSuccess(true);
            result.setMsg("删除成功");
        }else {
            result.setSuccess(false);
            result.setMsg("删除失败，请重试");
        }
        return result;
    }
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody AppVersion appVersion){
        appVersion.setCreateDate(new Date());
        appVersion.setUpdateDate(new Date());
        appVersion.setCreateBy("2,超级管理员");
        appVersion.setDelFlag("0");
        int insert = service.insertSelective(appVersion);
        Result result = new Result();
        if(insert>0){
            result.setSuccess(true);
            result.setMsg("保存成功");
        }else {
            result.setSuccess(false);
            result.setMsg("保存失败");
        }
        return result;
    }

}
