package cn.nyse.controller;


import cn.nyse.entity.AppVersion;
import cn.nyse.service.AppVersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manager/app")
public class AppVersionController {


    @Autowired
    AppVersionService service;


    @RequestMapping("toIndex")
    @ResponseBody
    public PageInfo<AppVersion> list(@RequestParam(defaultValue = "1",name = "pageNum") int pageNum, @RequestParam(defaultValue = "5",name = "pageSzie") int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AppVersion> appVersions = service.selectAll();
        PageInfo<AppVersion> pageInfo = new PageInfo<>(appVersions);
        return pageInfo;
    }

    @RequestMapping("index")
    public String toIndex() {
        return "/app/index";
    }

    @RequestMapping("deleted")
    @ResponseBody
    public boolean delete(int id) {
        int i = service.deleteByPrimaryKey(id);
        return i > 0 ? true : false;
    }

    @RequestMapping("save")
    @ResponseBody
    public int save(AppVersion appVersion) {
        appVersion.setCreateDate(new Date());
        appVersion.setUpdateDate(new Date());
        appVersion.setDelFlag("0");
        return service.insertSelective(appVersion);
    }

    @RequestMapping("/detail/showlayer")
    public ModelAndView showlayer(int id) {
        AppVersion appVersion = service.selectByPrimaryKey(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/app/detail");
        modelAndView.addObject("app", appVersion);
        return modelAndView;
    }
/*    @RequestMapping("/detail/showlayer")
    public ModelAndView showlayer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/app/detail");
        return modelAndView;
    }*/
}
