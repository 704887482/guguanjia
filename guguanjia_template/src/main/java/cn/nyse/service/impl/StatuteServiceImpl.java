package cn.nyse.service.impl;

import cn.nyse.entity.Statute;
import cn.nyse.service.StatuteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author hhy
 * @Date 2019/10/11 12:45
 */
@Service
@Transactional
public class StatuteServiceImpl extends ServiceImpl<Statute> implements StatuteService {

    @Override
    public List<Statute> selectByExample(String type) {
        Example example = new Example(Statute.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("delFlag","0");
        if (!StringUtils.isEmpty(type)){
            criteria.andEqualTo("type",type);
        }
        example.setOrderByClause("pub_date desc");
        return mapper.selectByExample(example);
    }
}
