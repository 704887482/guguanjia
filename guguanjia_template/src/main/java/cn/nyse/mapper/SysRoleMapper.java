package cn.nyse.mapper;

import cn.nyse.entity.SysRole;
import cn.nyse.entity.SysUser;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends Mapper<SysRole> {

    /*
    * 查询角色id、角色名和角色公司名
    * */

    @Select("SELECT a.id role_id,CONCAT(a.`name`,' (',b.`name`,')') role_name FROM sys_role a,sys_office b WHERE a.office_id=b.id")
    List<Map<String,Object>> findRoles();

    @Select("SELECT a.name " +
            "FROM " +
            "sys_role a,sys_user_role b " +
            "WHERE " +
            "a.id=b.role_id " +
            "AND " +
            "user_id=#{id} ")
    List<String> selectRoleAndUser(Long id);

    @SelectProvider(type = SysRoleMapperProvider.class,method = "findRolesByCondition")
    List<Map<String,Object>> findRolesByCondition(Map<String,Object> params);
    
    @Select("SELECT c.id,c.`name` FROM " +
            "sys_role a,sys_user_role b,sys_user c " +
            "WHERE " +
            "a.id=#{id} " +
            "and " +
            "a.id=b.role_id  " +
            "AND  " +
            "b.user_id=c.id ")
    List<SysUser> findUserByRid(Long id);

    @Select("select c.* from  " +
            "sys_role a,sys_user_role b,sys_user c " +
            "where  " +
            "a.id=#{id} " +
            "and " +
            "a.id=b.role_id " +
            "and " +
            "b.user_id=c.id")
    List<SysUser> findUsersByRid(int id);

    @Select("SELECT a.`name` role_name,b.`name` office_name,a.data_scope ,b.`master` ,a.create_by ,a.create_date ,a.update_by ,a.update_date ,a.remarks  " +
            "                 FROM       " +
            "                 sys_role a       " +
            "                 LEFT JOIN       " +
            "                 sys_office b       " +
            "                 ON       " +
            "                 a.office_id=b.id    " +
            "where a.id=#{id}")
    Map<String, Object> detail(int id);

    @InsertProvider(type = SysRoleMapperProvider.class,method = "insertUsersRole")
    int insertUsersRole(@Param("ids")int[] ids,@Param("rid") int rid);

    @Insert("DELETE FROM sys_user_role WHERE 1=1 and user_id= #{ids} AND role_id= #{rid}")
    int deleteUsersRole(@Param("ids") int ids,@Param("rid") int rid);

    @Select("SELECT `id`, `office_id`, `name`, `data_scope`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag` FROM sys_role GROUP BY data_scope")
    List<SysRole> selectScope();

    @Select("SELECT c.id FROM " +
            "sys_user a,sys_user_role b,sys_role c " +
            "WHERE " +
            "a.id=#{uid} " +
            "AND " +
            "a.id=b.user_id " +
            "and " +
            "b.role_id=c.id")
    List<SysRole> selectByUid(long uid);
}