package cn.nyse.service.impl;

import cn.nyse.entity.Statute;
import cn.nyse.service.StatuteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class StatuteServiceImpl extends ServiceImpl<Statute> implements StatuteService {


    @Override
    public List<Statute> selectByExample(String type) {
        Example example = new Example(Statute.class);//生成Example动态sql对象  select * from  statute
        Example.Criteria criteria = example.createCriteria();//生成映射处理对象
        criteria.andEqualTo("delFlag","0");//传入属性名和属性值，自动转换成字段名和字段值 where delFlag=0
//        mapper.selectByExample()

        //StringUtils spring框架提供的字符串工具类
        if(!StringUtils.isEmpty(type)){
            criteria.andEqualTo("type",type);
        }
        example.setOrderByClause("pub_date desc");//example直接拼接sql
        return   mapper.selectByExample(example);
    }
}
