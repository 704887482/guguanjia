package cn.nyse.config;


import cn.nyse.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//静态资源放行   视图解析器   开启controller扫描   mvc注解支持
@Configuration
@ComponentScan(basePackages = "cn.nyse.controller")
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override//放行静态资源
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*
    视图解析器，默认跳转html
     */
    @Bean
    public InternalResourceViewResolver getViewResolver(){
       return new InternalResourceViewResolver("/WEB-INF/views",".html");
    }

    @Bean("multipartResolver")//指定bean的名字
    public CommonsMultipartResolver getMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }
/*
* 注册拦截器
* */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns(new String[]{"/","/login"});

    }
}
