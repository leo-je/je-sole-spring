package com.je.cloud.busi.document.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DocumentWebSourceConfig implements WebMvcConfigurer {

    @Autowired
    private DocumentConfig documentConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/getfile/**").addResourceLocations("file:" + documentConfig.getStorageFolder());
    }
}