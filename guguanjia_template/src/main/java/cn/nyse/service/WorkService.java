package cn.nyse.service;

import cn.nyse.entity.WorkOrder;

import java.util.List;
import java.util.Map;

public interface WorkService extends IService<WorkOrder>{

    public List<Map<String,Object>> selectByCondition(Map<String, Object> map);

    Map<String,Object> selectOneByCondition(int id);
}
