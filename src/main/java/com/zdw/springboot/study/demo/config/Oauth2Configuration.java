package com.zdw.springboot.study.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/4/1
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Configuration
public class Oauth2Configuration {

    @Configuration
    @EnableResourceServer
    protected  static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

        @Autowired
        private MyCustomAuthenticationEntryPoint entryPoint;

        @Autowired
        private LoginOutSuccessHandler successHandler;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.exceptionHandling()
                    .authenticationEntryPoint(entryPoint)
                    .and().logout().logoutSuccessHandler(successHandler)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/**").permitAll();
                   // .antMatchers("/user/view").permitAll()
                   // .antMatchers("/user/**").authenticated();
        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected  static  class MyAuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        private static final String env_oauthn = "authentication.oauth";
        private static final String clientID = "clientId";
        private static final String tokenSeconds = "tokenValidityInSeconds";
        @Autowired
        DataSource dataSource;

        @Bean
        public TokenStore tokenStore(){
            return new JdbcTokenStore(dataSource);
        }

        @Autowired
        AuthenticationManager authenticationManagerBean;

        @Autowired
        PasswordEncoder passwordEncoder;


        @Bean
        JdbcClientDetailsService jdbcCleintDetail(){
            return new JdbcClientDetailsService(dataSource);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.tokenStore(tokenStore())
                    .authenticationManager(authenticationManagerBean);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            /*clients.inMemory()
                    .withClient("clientdID")
                    .scopes("read", "write")
                    .authorities("ROLE_ADMIN","ROLE_USER")
                    .authorizedGrantTypes("password","refresh_token")
                    .secret(passwordEncoder.encode("123456"))
                    .accessTokenValiditySeconds(3000);*/
            clients.withClientDetails(jdbcCleintDetail());
        }
    }
}
