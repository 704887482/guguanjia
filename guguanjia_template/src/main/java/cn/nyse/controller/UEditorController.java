package cn.nyse.controller;


import cn.nyse.utils.UEditorUtil;
import com.baidu.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/manager/ueditor")
public class UEditorController {

    @Autowired
    UEditorUtil editorUtil;

    @RequestMapping("config")
    @ResponseBody
    public String config(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "uploadfile",required = false) MultipartFile uploadfile){
        String realPath=request.getServletContext().getRealPath("/");
        String exec="";
        String actionType=request.getParameter("action");
        if ("config".equals(actionType)){//获取后台配置json字符串请求
            exec=new ActionEnter(request,realPath).exec();
        }else if ("uploadimage".equals(actionType)){
            System.out.println("模拟图片上传...");
            exec=editorUtil.uploadImg(uploadfile,request);
        }else if ("uploadfile".equals(actionType)){
            System.out.println("模拟文件上传...");
        }
        return exec;
    }

}
