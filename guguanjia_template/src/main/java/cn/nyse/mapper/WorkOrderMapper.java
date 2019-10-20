package cn.nyse.mapper;

import cn.nyse.entity.WorkOrder;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface WorkOrderMapper extends Mapper<WorkOrder> {

    @SelectProvider(type = WorkOrderProvider.class,method = "selectByCondition")
    List<Map<String, Object>> selectByCondition(Map<String, Object> map);


    @Select("select  " +
            "wo.`code`,wo.`status`, " +
            "cu.`name` create_name,co.`name` create_company,tu.`name` transport_name,transportOffice.`name` transport_company,ru.`name` recipient_name,ro.`name` recipient_company, " +
            "cu.mobile create_mobile,tu.mobile transport_mobile,ru.mobile recipient_mobile " +
            "from " +
            "work_order wo " +
            "left join " +
            "sys_user cu " +
            "on " +
            "wo.create_user_id=cu.id " +
            "left join " +
            "sys_user tu " +
            "on " +
            "wo.transport_user_id=tu.id " +
            "left join " +
            "sys_user ru " +
            "on " +
            "wo.recipient_user_id=ru.id " +
            "left join " +
            "sys_office co " +
            "on " +
            "cu.company_id=co.id " +
            "left join " +
            "sys_office transportOffice " +
            "on " +
            "tu.company_id=transportOffice.id " +
            "left join " +
            "sys_office ro " +
            "on " +
            "ru.company_id=ro.id " +
            "where  " +
            "wo.id=#{id}")
    Map<String,Object> selectOneByCondition(int id);
}