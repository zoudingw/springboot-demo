package com.zdw.springboot.study.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/4/1
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Component
public class MyCustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    Logger logger = LoggerFactory.getLogger(MyCustomAuthenticationEntryPoint.class);
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("=========================授权失败==================");
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Access denied");
    }
}
