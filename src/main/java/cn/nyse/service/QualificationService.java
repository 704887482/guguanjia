package cn.nyse.service;

import cn.nyse.entity.Qualification;

import java.util.List;
import java.util.Map;

public interface QualificationService extends  IService<Qualification> {
    List<Map<String,Object>> selectByCondition(Map<String, Object> params);
}
