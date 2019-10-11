package cn.nyse.service.impl;

import cn.nyse.entity.Qualification;
import cn.nyse.mapper.QualificationMapper;
import cn.nyse.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QualificationServiceImpl extends ServiceImpl<Qualification> implements QualificationService {

    @Autowired
    QualificationMapper qualificationMapper;

    @Override
    public List<Map<String,Object>> selectByCondition(Map<String, Object> params){
        return qualificationMapper.selectByCondition(params);
    }
}
