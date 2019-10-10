package cn.nyse.mapper;

import cn.nyse.entity.User;
import cn.nyse.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from app_version",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into app_version (id, platform, ",
        "version_no, force_update, ",
        "down_path, size, app_explain, ",
        "create_date, update_date, ",
        "del_flag, create_by)",
        "values (#{id,jdbcType=BIGINT}, #{platform,jdbcType=INTEGER}, ",
        "#{versionNo,jdbcType=VARCHAR}, #{forceUpdate,jdbcType=INTEGER}, ",
        "#{downPath,jdbcType=VARCHAR}, #{size,jdbcType=REAL}, #{appExplain,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{delFlag,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platform", property="platform", jdbcType=JdbcType.INTEGER),
        @Result(column="version_no", property="versionNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="force_update", property="forceUpdate", jdbcType=JdbcType.INTEGER),
        @Result(column="down_path", property="downPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.REAL),
        @Result(column="app_explain", property="appExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, platform, version_no, force_update, down_path, size, app_explain, create_date, ",
        "update_date, del_flag, create_by",
        "from app_version",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platform", property="platform", jdbcType=JdbcType.INTEGER),
        @Result(column="version_no", property="versionNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="force_update", property="forceUpdate", jdbcType=JdbcType.INTEGER),
        @Result(column="down_path", property="downPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.REAL),
        @Result(column="app_explain", property="appExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update app_version",
        "set platform = #{platform,jdbcType=INTEGER},",
          "version_no = #{versionNo,jdbcType=VARCHAR},",
          "force_update = #{forceUpdate,jdbcType=INTEGER},",
          "down_path = #{downPath,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=REAL},",
          "app_explain = #{appExplain,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "del_flag = #{delFlag,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}