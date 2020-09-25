package com.je.cloud.quartz.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT的token，区分大小写
 */
@ConfigurationProperties(prefix = "je.quartz")
@Component
public class QuartzConfig {

    private String propertiesFilePath = null;

    public String getPropertiesFilePath() {
        return propertiesFilePath;
    }

    public void setPropertiesFilePath(String propertiesFilePath) {
        this.propertiesFilePath = propertiesFilePath;
    }
}
