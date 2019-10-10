package cn.nyse.controller;

import cn.nyse.entity.Demand;
import cn.nyse.service.DemandService;
import cn.nyse.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author hhy
 * @Date 2019/10/10 14:47
 */
@Controller
@RequestMapping("/manager/demand")
public class DemandController {

    @Autowired
    DemandService service;

    @RequestMapping("index")
    public String demand(){
        return "/demand/index";
    }

    @RequestMapping("toIndex")
    @ResponseBody
    public PageInfo<Demand> toIndex(@RequestParam(defaultValue = "1",name = "pageNum") int pageNum,@RequestParam(defaultValue = "5",name = "pageSize") int pageSize){
        //初始化分页
        PageHelper.startPage(pageNum,pageSize);
        //查询列表
        List<Demand> demands = service.selectAll();
        //插入列表到分页插件
        PageInfo<Demand> demandPageInfo = new PageInfo<>(demands);
        return demandPageInfo;
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Demand selectById(int id){
        return service.selectByPrimaryKey(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody Demand demand){
        Result result=new Result();
        int i = service.updateByPrimaryKeySelective(demand);
        if (i>0){
            result.setSuccess(true);
            result.setMsg("更新成功");
        }else {
            result.setSuccess(false);
            result.setMsg("更新失败");
        }
        return result;
    }
}
