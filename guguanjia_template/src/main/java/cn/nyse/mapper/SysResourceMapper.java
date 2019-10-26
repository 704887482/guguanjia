package cn.nyse.mapper;

import cn.nyse.entity.SysResource;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysResourceMapper extends Mapper<SysResource> {


    @SelectProvider(type = SysResourceMapperProvider.class,method = "selectPage")
    List<Map<String, Object>> selectPage(Map<String, Object> params);

    @Select("SELECT a.id,a.parent_id,b.`NAME` FROM sys_resource a,sys_resource b WHERE a.id= #{id} AND a.id=b.id")
    SysResource selectParentId(Long id);

    @Select("SELECT c.* FROM " +
            "sys_role a,sys_role_resource b,sys_resource c " +
            "WHERE " +
            "a.id=#{rid} " +
            "and " +
            "a.id=b.role_id " +
            "and " +
            "b.resource_id=c.id")
    List<SysResource> selectByRid(long rid);
}