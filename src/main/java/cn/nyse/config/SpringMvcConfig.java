package cn.nyse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author hhy
 * @Date 2019/9/30 16:36
 */
@EnableWebMvc
@ComponentScan(basePackages = "cn.nyse.controller")
public class SpringMvcConfig {

}
