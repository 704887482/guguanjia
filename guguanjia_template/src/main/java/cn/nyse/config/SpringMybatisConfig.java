package cn.nyse.config;


import cn.nyse.utils.MapWrapperFactory;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * spring与mybatis集成配置
 * spring事务配置
 *
 * 数据源创建、SqlSessionFactoryBean、扫描mapper、扫描服务层类、事务管理器、事务注解支持
 * 配置分页支持
 */

@Configuration
@MapperScan(basePackages = "cn.nyse.mapper")//扫描mapper
@ComponentScan(basePackages = {"cn.nyse.service","cn.nyse.utils","cn.nyse.aspect"})//扫描服务层
@EnableTransactionManagement//事务注解支持
@PropertySource(value = "classpath:sys.properties",encoding = "utf-8")
@Import(value = SpringRedisConfig.class)
//@EnableAspectJAutoProxy//开启aop注解支持
public class SpringMybatisConfig {


//数据源
    @Bean
    public DruidDataSource getDataSource(){
        Properties properties = new Properties();
        try {
            properties.load(SpringMybatisConfig.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(properties);
        //配置使用druid内置filter  通过别名，别名...的方式设置
        //stat：开启监控功能过滤器
        try {
            druidDataSource.setFilters("stat,wall,log4j2");
            druidDataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=1000");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
    //sqlSessionFactor创建
    @Bean
    public SqlSessionFactoryBean  getSessionFactoryBean(DruidDataSource dataSource){
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //tkmapper 需要使用  tkmapper提供的configuration
        //默认使用驼峰命名转换
        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
        configuration.setLogImpl(Log4j2Impl.class);//设置日志类
        configuration.setMapUnderscoreToCamelCase(true);//设置驼峰命名转换
        configuration.setCallSettersOnNulls(true);
        configuration.setObjectWrapperFactory(new MapWrapperFactory());
        sessionFactoryBean.setConfiguration(configuration);
        /*分页pagehelper*/
        PageInterceptor pageInterceptor=new PageInterceptor();
        pageInterceptor.setProperties(new Properties());
        sessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        return sessionFactoryBean;

    }

    @Bean/*事务管理器*/
    public DataSourceTransactionManager getTransactionManager(DruidDataSource dataSource){
       return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "druidStatInterceptor")//设置druid的aop切面类
    public DruidStatInterceptor getDruidStatInterceptor(){
        DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();
        return druidStatInterceptor;
    }

    @Bean//配置spring监控
    public BeanNameAutoProxyCreator getAutoProxyCreator(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setProxyTargetClass(true);
        beanNameAutoProxyCreator.setBeanNames(new String[]{"*Mapper","*Service*"});
        beanNameAutoProxyCreator.setInterceptorNames("druidStatInterceptor");
        return beanNameAutoProxyCreator;
    }

}
