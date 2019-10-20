package cn.nyse.mapper;

import cn.nyse.entity.Detail;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface DetailMapper extends Mapper<Detail> {

    /*
    * 查询工单的详细运输信息
    * */

    @Select("select a.plate_number,b.`code` waste_type_code,b.`name`,c.`code` waste_code,a.component,a.weight,a.morphological,a.packaging"+
             " from detail a,waste_type b,waste c where a.waste_type_id=b.id and a.waste_id=c.id and a.work_order_id=#{workOrderId}"     )
    List<Map<String,Object>> selectByCondition(int workOrderId);

}