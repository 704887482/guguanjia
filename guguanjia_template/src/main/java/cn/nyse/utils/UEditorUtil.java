package cn.nyse.utils;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UEditorUtil {

    @Value("${img.path}")
    String imgPath;

    @Value("${img.realPath}")
    String imgRealPath;

    //文件上传
    public String uploadImg(MultipartFile file, HttpServletRequest request){
        /*
        *1.获取文件名，文件后缀  随机生成文件名
        * 2.文件上传
        * 3.处理返回数据结果
        * */
        String filename=file.getOriginalFilename();//获取文件名
        String lastname=filename.substring(filename.lastIndexOf("."));//获取原文件后缀
        String uuid= UUID.randomUUID().toString();
        String targetName=uuid+lastname;//新文件名
        String url=imgPath+ File.separator+targetName;

        File dir = new File(imgRealPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        JSONObject jsonObject=null;
        //保存
        File targetFile = new File(imgRealPath + File.separator + targetName);
        try {
            file.transferTo(targetFile);
            jsonObject=new JSONObject(resultMap("SUCCESS",url,file.getSize(),targetName,filename,lastname));
        } catch (IOException e) {
            jsonObject=new JSONObject(resultMap("SUCCESS",null,0,null,null,null));
            e.printStackTrace();
        }
        return jsonObject.toString();
    }





    //设置图片上传处理的返回数据功能
    //{"state": "SUCCESS","original": "111.jpg","size": "124147","title": "1535961757878095151.jpg","type": ".jpg","url": "/1535961757878095151.jpg"}
    public  Map<String,Object> resultMap(String state, String url, long size, String title, String original, String type){
        Map<String ,Object> result = new HashMap<>();
        result.put("state",state);
        result.put("original",original);
        result.put("size",size);
        result.put("title",title);
        result.put("type",type);
        result.put("url", url);
        return result;
    }
}
