package cn.nyse.mapper;

import cn.nyse.entity.SysArea;
import cn.nyse.vo.SysAreaVo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysAreaMapper extends Mapper<SysArea> {


     @Select("select  " +
             "a.*,b.name parent_name " +
             "from  " +
             "sys_area a " +
             "left join " +
             "sys_area b " +
             "on " +
             "a.parent_id=b.id " +
             "where " +
             "a.id=#{aid} " +
             "and a.del_flag=0")
     SysArea selectOneByAid(int aid);

     /*
     根据父节点的id、旧parentIds、新parentIds
     更新  子节点 的 parentIds
     * */
     @Update("update sys_area set parent_ids" +
             "= REPLACE(parent_ids,#{oldParentIds},#{parentIds})" +
             " where parent_ids like concat('%',#{id},'%')"
     )
     int updateParentIds(SysArea sysArea);

     @Select("select a.*,b.`name` parent_name from sys_area a LEFT JOIN sys_area b ON a.parent_id=b.id " +
             "where a.del_flag=0")
     List<SysArea> selectAll2();

     @Select("select a.*,b.`name` parent_name from sys_area a LEFT JOIN sys_area b ON a.parent_id=b.id where a.id=#{id} and b.`name`=#{parentName} ")
     SysArea checkParentName(SysArea sysArea);

     @InsertProvider(type = SysAreaMapperProvider.class,method="saveBatch")
     int insertBatch(@Param("sysAreaVos") List<SysAreaVo> sysAreaVos);
//查询该id下的公司
     @Select("select count(0) from sys_office where area_id in (select id from sys_area where find_in_set(#{id},parent_ids) or id=#{id})")
     int selectCountOffice(int id);
//     区域删除
     @Update("update sys_area set del_flag=1 where find_in_set(#{id},parent_ids) or id=#{id}")
     int updateAreaAndSub(int id);
}