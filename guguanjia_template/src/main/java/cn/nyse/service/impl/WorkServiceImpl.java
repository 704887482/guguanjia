package cn.nyse.service.impl;

import cn.nyse.entity.WorkOrder;
import cn.nyse.mapper.DetailMapper;
import cn.nyse.mapper.TransferMapper;
import cn.nyse.mapper.WorkOrderMapper;
import cn.nyse.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author hhy
 * @Date 2019/10/10 18:11
 */
@Service
@Transactional
public class WorkServiceImpl extends ServiceImpl<WorkOrder> implements WorkService {

    @Autowired
    WorkOrderMapper mapper;

    @Autowired
    DetailMapper detailMapper;

    @Autowired
    TransferMapper transferMapper;

    public List<Map<String,Object>> selectByCondition(Map<String, Object> map){
        return mapper.selectByCondition(map);
    }

    /*
    * 工单详情查询，根据传入工单id查询信息
    * */
    @Override
    public Map<String, Object> selectOneByCondition(int id) {
        Map<String,Object> workDetail=mapper.selectOneByCondition(id);
        List<Map<String, Object>> details = detailMapper.selectByCondition(id);
        List<Map<String, Object>> transfers = transferMapper.selectByCondition(id);
        workDetail.put("details",details);
        workDetail.put("transfers",transfers);
        return workDetail;
    }


}
