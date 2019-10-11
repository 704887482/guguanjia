package cn.nyse.controller;

import cn.nyse.entity.Statute;
import cn.nyse.service.StatuteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manager/statute")
public class StatuteController {

    @Autowired
    StatuteService service;

    @RequestMapping("index")
    public String index(){
        return "/statute/index";
    }


    /**
     * 带条件分页查询，返回分页对象
     * @return
     */
    @RequestMapping("toIndex")
    @ResponseBody
    public PageInfo<Statute> toIndex(String type, @RequestParam(name="pageNum",defaultValue = "1") int pageNum,@RequestParam(name="pageSize",defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(service.selectByExample(type));
    }

}
