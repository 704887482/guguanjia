import cn.nyse.config.SpringMybatisConfig;
import cn.nyse.entity.Statute;
import cn.nyse.mapper.StatuteMapper;
import cn.nyse.service.StatuteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author hhy
 * @Date 2019/10/11 12:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestStatute {

    @Autowired
    StatuteMapper mapper;

    @Autowired
    StatuteService service;

    @Test
    public void test(){
        Example example = new Example(Statute.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("delFlag","0");
        String type="1";
        if (!StringUtils.isEmpty(type)){
            criteria.andEqualTo("type",type);
        }
        example.setOrderByClause("update_date desc");
        List<Statute> statutes = mapper.selectByExample(example);


//        StatuteExample statuteExample=new StatuteExample();
//        StatuteExample.Criteria exampleCriteria=statuteExample.createCriteria();
//        exampleCriteria.andDelFlagEqualTo("0");
//        statuteExample.setOrderByClause("update_date desc");
//        List<Statute> statutes = mapper.selectByExample(statuteExample);

    }
    @Test
    public void test2(){
        String str="123.jsp";
        int i=str.lastIndexOf(".");
        String lastname=str.substring(1,2);
        System.out.println(lastname);
    }

}
