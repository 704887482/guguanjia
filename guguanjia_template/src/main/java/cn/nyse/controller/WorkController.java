package cn.nyse.controller;

import cn.nyse.entity.WorkOrder;
import cn.nyse.service.WorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author hhy
 * @Date 2019/10/10 18:10
 */
@Controller
@RequestMapping("/manager/admin")
public class WorkController {

    @Autowired
    WorkService service;

    @RequestMapping("work")
    public String work(){
        return "/work/admin/work";
    }

    @RequestMapping("toIndex")
    @ResponseBody
    public PageInfo<WorkOrder> toIndex(@RequestParam(defaultValue = "1",name = "pageNum") int pageNum, @RequestParam(defaultValue = "5",name = "pageSize") int pageSize){
        //初始化分页插件
        PageHelper.startPage(pageNum,pageSize);
        //查询list
        List<WorkOrder> works = service.selectAll();
        PageInfo<WorkOrder> workPageInfo = new PageInfo<>(works);
        return workPageInfo;
    }
}
