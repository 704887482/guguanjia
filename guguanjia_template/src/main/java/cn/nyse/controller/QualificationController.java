package cn.nyse.controller;

import cn.nyse.entity.Qualification;
import cn.nyse.service.QualificationService;
import cn.nyse.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    /**
     * 通过resfult风格实现
     * @return
     */
    @RequestMapping(value = "/selectById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectById(@PathVariable("id") int id){
        return service.selectById(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody Qualification qualification) {
        int i = service.updateByPrimaryKeySelective(qualification);
        Result result = new Result();
        if (i > 0) {
            result.setSuccess(true);
            result.setMsg("更新成功");
        } else {
            result.setSuccess(false);
            result.setMsg("更新失败，请重试");
        }
        return result;
    }
}
