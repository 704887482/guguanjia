import cn.nyse.config.SpringMybatisConfig;
import cn.nyse.mapper.QualificationMapper;
import cn.nyse.service.QualificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestQualification {


   
    @Autowired
    QualificationMapper mapper;

    @Autowired
    QualificationService service;



    @Test
    public void testSelectByCondition(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("startDate","2017-01-01");
        map.put("type",'1');

        List<Map<String, Object>> list = service.selectByCondition(map);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }

    }


}
