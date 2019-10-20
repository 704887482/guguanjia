package cn.nyse.mapper;

import cn.nyse.entity.Transfer;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TransferMapper extends Mapper<Transfer> {

    /*
    * 查询转运记录
    * */
    @Select("select a.create_date,a.content,b.phone,b.mobile from transfer a,sys_user b where "+
             " a.work_order_id=#{wordOrderId} and a.oprate_user_id=b.id order by a.create_date desc")
    List<Map<String,Object>> selectByCondition(int wordOrderId);
}