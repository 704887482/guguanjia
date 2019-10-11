package cn.nyse.mapper;

import cn.nyse.entity.Statute;
import cn.nyse.entity.StatuteExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StatuteMapper extends Mapper<Statute> {

}