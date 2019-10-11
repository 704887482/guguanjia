import cn.nyse.config.SpringMybatisConfig;
import cn.nyse.entity.Statute;
import cn.nyse.entity.StatuteExample;
import cn.nyse.mapper.StatuteMapper;
import cn.nyse.service.StatuteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestDeman {


   
    @Autowired
    StatuteMapper mapper;

    @Autowired
    StatuteService service;


    /**
     * Example:动态条件处理类
     * 可以通过tkmapper提供的Example和MBG生成的xxxExample类来处理
     *
     * 需求：
     * 1.根据type动态查询
     * 2.查询del_flag为0
     * 3.根据更新时间倒序排序
     */
    @Test
    public void testMapper(){
       /* Example example = new Example(Statute.class);//生成Example动态sql对象  select * from  statute
        Example.Criteria criteria = example.createCriteria();//生成映射处理对象
        criteria.andEqualTo("delFlag","0");//传入属性名和属性值，自动转换成字段名和字段值 where delFlag=0
//        mapper.selectByExample()
        String type = "1";
        //StringUtils spring框架提供的字符串工具类
        if(!StringUtils.isEmpty(type)){
            criteria.andEqualTo("type",type);
        }
        example.setOrderByClause("update_date desc");//example直接拼接sql
        List<Statute> statutes = mapper.selectByExample(example);*/
        /*for (Statute statute : statutes) {
            System.out.println(statute);
        }*/
//        System.out.println(statutes);

        StatuteExample statuteExample = new StatuteExample();
        StatuteExample.Criteria exampleCriteria = statuteExample.createCriteria();
        exampleCriteria.andDelFlagEqualTo("0");//and del_flag = xxx
        statuteExample.setOrderByClause("update_date desc");
        List<Statute> statutes2 = mapper.selectByExample(statuteExample);
    }


}
