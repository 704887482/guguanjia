package cn.nyse.service.impl;

import cn.nyse.entity.Qualification;
import cn.nyse.mapper.QualificationMapper;
import cn.nyse.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QualificationServiceImpl extends ServiceImpl<Qualification> implements QualificationService {

    @Value("${img.path}")
    String imgPath;

    @Autowired
    QualificationMapper qualificationMapper;

    @Override
    public List<Map<String,Object>> selectByCondition(Map<String, Object> params){
        return qualificationMapper.selectByCondition(params);
    }


    @Override
    public Map<String, Object> selectById(int id){
        Map<String,Object> map = qualificationMapper.selectById(id);
        if(map.containsKey("address")&&!StringUtils.isEmpty(map.get("address"))){
            map.put("address",imgPath+ map.get("address"));//拼接虚拟路径
        }
        return map;
    }

}
