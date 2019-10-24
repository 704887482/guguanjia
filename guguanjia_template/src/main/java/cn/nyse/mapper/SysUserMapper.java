package cn.nyse.mapper;

import cn.nyse.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends Mapper<SysUser> {



    @SelectProvider(type = SysUserMapperProvider.class,method = "selectPage")
    List<Map<String,Object>> selectPage(Map<String, Object> params);

    @SelectProvider(type = SysUserMapperProvider.class,method = "selectByOne")
    Map<String, Object> selectByOne(Long id);

    @SelectProvider(type = SysUserMapperProvider.class,method = "selectByRoleId")
    List<String> selectByRoleId(Long id);

    /**
     * 根据公司id查询用户，去除已经指定角色id中的用户
     * @param oid
     * @return
     */
    @Select("select * from sys_user a where office_id=#{oid} " +
            "and " +
            "a.id  " +
            "not in  " +
            "(select c.id from  " +
            "sys_role a,sys_user_role b,sys_user c " +
            "where  " +
            "a.id=#{rid} " +
            "and " +
            "a.id=b.role_id " +
            "and " +
            "b.user_id=c.id)")
    List<SysUser> findUsersByOid(@Param("oid")int oid, @Param("rid")int rid);
}