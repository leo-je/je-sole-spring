package com.je.cloud.jwt.config;

import com.je.cloud.jwt.interceptor.TokenInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebJwtConfig implements WebMvcConfigurer {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TokenInterceptor tokenInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        log.info("-------------> jwt service addInterceptors ");
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
    }
}
