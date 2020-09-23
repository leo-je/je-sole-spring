package com.je.cloud.mybatis.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

public class PageHelperConfig {

    //@Bean
    public PageInterceptor getPageHelper() {
        PageInterceptor pageHelper = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
