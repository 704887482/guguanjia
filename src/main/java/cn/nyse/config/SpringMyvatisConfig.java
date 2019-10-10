package cn.nyse.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author hhy
 * @Date 2019/9/30 14:18
 */
@Configuration
@ComponentScan(basePackages = "cn.nyse.server")
@EnableTransactionManagement
public class SpringMyvatisConfig {

    //数据源
    public DruidDataSource getDataSource() throws IOException {
        Properties properties=new Properties();
        InputStream resourceAsStream = SpringMyvatisConfig.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(resourceAsStream);
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setConnectProperties(properties);
        return druidDataSource;
    }

    //配置mybayis
    public SqlSessionFactoryBean getSelSession(DruidDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Log4j2Impl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }

    //配置事务
    public DataSourceTransactionManager getTransactionManager(DruidDataSource dataSource){
        DataSourceTransactionManager transactionManager=new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

}
