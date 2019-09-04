package com.pinyou.config.xss;

import com.pinyou.config.filter.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName XssConfig
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月26日 11:21
 */
@Configuration
public class XssConfig {

    @Bean
    public FilterRegistrationBean xssFilter(){
        FilterRegistrationBean<XssFilter> registrationBean = new FilterRegistrationBean<>(new XssFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
