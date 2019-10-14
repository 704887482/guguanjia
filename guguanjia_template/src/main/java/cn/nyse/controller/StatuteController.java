package cn.nyse.controller;

import cn.nyse.entity.Statute;
import cn.nyse.service.StatuteService;
import cn.nyse.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author hhy
 * @Date 2019/10/11 12:43
 */
@Controller
@RequestMapping("/manager/statute")
public class StatuteController {

    @Autowired
    StatuteService service;

    @RequestMapping("index")
    public String index(){
        return "/statute/index";
    }

    @RequestMapping("toIndex")
    @ResponseBody
    public PageInfo<Statute> toIndex(String type, @RequestParam(name = "pageNum",defaultValue = "1") int pageNum,@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(service.selectByExample(type));
    }

    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody Statute statute){
        statute.setCreateDate(new Date());
        statute.setUpdateDate(new Date());
        statute.setDelFlag("0");
        int i = service.insertSelective(statute);
        Result result = new Result();
        if (i>0){
            result.setSuccess(true);
            result.setMsg("保存成功");
        }else {
            result.setMsg("保存失败，请重试");
        }
        return result;
    }

    @RequestMapping(value = "/selectById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Statute selectById(@PathVariable("id") int id){
        return service.selectByPrimaryKey(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody Statute statute){
        int i = service.updateByPrimaryKeySelective(statute);
        Result result = new Result();
        if (i>0){
            result.setSuccess(true);
            result.setMsg("更新成功！");
        }else {
            result.setMsg("更新失败！");
        }
        return result;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@PathVariable("id") int id){
        Result result = new Result();
        int i = service.deleteByPrimaryKey(id);
        if (i>0){
            result.setSuccess(true);
            result.setMsg("删除成功！");
        }else {
            result.setMsg("删除失败！");
        }
        return result;
    }
}
