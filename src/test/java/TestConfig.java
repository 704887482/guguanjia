import cn.nyse.config.SpringMybatisConfig;
import cn.nyse.entity.AppVersion;
import cn.nyse.mapper.AppVersionMapper;
import cn.nyse.service.AppVersionService;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestConfig {


    @Autowired
    DruidDataSource dataSource;

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;

    @Autowired
    AppVersionMapper mapper;

    @Autowired
    AppVersionService service;

    @Test
    public void getDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void  getSqlSessionFactoryBean() throws Exception {
        System.out.println(sqlSessionFactoryBean.getObject().openSession().getConnection());
    }

    @Test
    public void getMapper(){
        /**
         * 需要给tkmapper指定主键
         */
        AppVersion appVersion = mapper.selectByPrimaryKey( 1);
        System.out.println(appVersion);

//        List<AppVersion> appVersions = mapper.selectAll();

        int i = mapper.updateByPrimaryKeySelective(appVersion);
        System.out.println(i);


    }


    @Test
    public void getService(){
        List<AppVersion> appVersions = service.selectAll();
        for (AppVersion appVersion : appVersions) {
            System.out.println(appVersion);
        }
    }


    /**
     * 测试自增主键
     */
    @Test
    public void testSave(){
        AppVersion appVersion = new AppVersion();



        appVersion.setPlatform(0);
        appVersion.setVersionNo("");
        appVersion.setForceUpdate(0);
        appVersion.setDownPath("");
//        appVersion.setSize(0.0F);
//        appVersion.setAppExplain("");
        appVersion.setCreateDate(new Date());
        appVersion.setUpdateDate(new Date());
        appVersion.setDelFlag("");
        appVersion.setCreateBy("");
        int i = mapper.insertSelective(appVersion);
        System.out.println(appVersion);
    }
}
