package com.pinyou.config.shiro;

import com.pinyou.config.filter.jwt.JwtFilter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @ClassName ShrioConfig
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月14日 15:35
 */
@Configuration
public class ShiroConfig {

    /**
     * 配置shiro 安全管理器
     *
     * @param shiroRealm 自定义realm
     * @return
     */
    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);

        //关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);

        //filter执行链
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login","anon");
        //添加jwt过滤器
        HashMap<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt",new JwtFilter());
        filterFactoryBean.setFilters(filterMap);
        //将jwt过滤器添加到执行链中
        map.put("/**","jwt");

        filterFactoryBean.setFilterChainDefinitionMap(map);

        return filterFactoryBean;
    }

    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

}
