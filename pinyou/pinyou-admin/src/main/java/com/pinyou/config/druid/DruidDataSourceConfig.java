package com.pinyou.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 * @ClassName DruidDataSourceConfig
 * @Discription druid数据源配置类
 * @Author zhidong.li
 * @Date 2019年08月12日 14:36
 */
@Configuration
public class DruidDataSourceConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new StatViewServlet());
        registrationBean.addUrlMappings("/druid/*");
        /** 白名单 */
        registrationBean.addInitParameter("allow", "127.0.0.1,115.192.17.238");
        /** IP黑名单(共同存在时，deny优先于allow) */
        // reg.addInitParameter("deny", "192.168.2.105");
        /** /druid/login.html登录时账号密码 */
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "admin");
        /** 是否能够重置数据 禁用HTML页面上的“Reset All”功能 */
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean druidStatFilter = new FilterRegistrationBean();
        druidStatFilter.setFilter(new WebStatFilter());
        /** 添加过滤规则. */
        druidStatFilter.addUrlPatterns("/*");
        /** 监控选项滤器 */
        druidStatFilter.addInitParameter("DruidWebStatFilter", "/*");
        /** 添加不需要忽略的格式信息. */
        druidStatFilter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,*.htm,/druid/*");
        /** 配置profileEnable能够监控单个url调用的sql列表 */
        druidStatFilter.addInitParameter("profileEnable", "true");
        /** 当前的cookie的用户 */
        druidStatFilter.addInitParameter("principalCookieName", "USER_COOKIE");
        /** 当前的session的用户 */
        druidStatFilter.addInitParameter("principalSessionName", "USER_SESSION");
        return druidStatFilter;
    }
}
