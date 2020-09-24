package com.je.cloud.busi.document.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DocumentWebSourceConfig implements WebMvcConfigurer {

    @Value("${fileTempPath}")
    private String filetemppath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/getfile/**").addResourceLocations("file:"+filetemppath);
    }
}