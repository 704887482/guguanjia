package cn.nyse.mapper;

import cn.nyse.entity.Qualification;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface QualificationMapper extends Mapper<Qualification> {


    //通过传入参数，动态生成sql，查询多表数据  返回 封装多表的结果字段，与列表页面的属性对应
    @SelectProvider(type = QualificationProvider.class,method="selectByCondition")
    List<Map<String,Object>>  selectByCondition(Map<String,Object> params);
}