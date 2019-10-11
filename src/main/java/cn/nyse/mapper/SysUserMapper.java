package cn.nyse.mapper;

import cn.nyse.entity.SysUser;
import cn.nyse.entity.SysUserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {

}