package com.zdw.springboot.study.demo.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChain = new LinkedHashMap<>();
        filterChain.put("/static/**", "anon");
        filterChain.put("/logout", "logout");
        filterChain.put("/**", "authc");
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("index");
        factoryBean.setUnauthorizedUrl("403");
        factoryBean.setFilterChainDefinitionMap(filterChain);
        return factoryBean;
    }
}
