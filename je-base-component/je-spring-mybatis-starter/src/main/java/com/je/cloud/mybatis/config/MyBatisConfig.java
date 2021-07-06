package com.je.cloud.mybatis.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = MyBatisConfig.CONFIG_PREFIX)
public class MyBatisConfig {

    public static final String CONFIG_PREFIX = "je.mybatis";
    private String typeAliasesPackage = "com.je.**.entity";

    private String mapperPath = "classpath*:com/je/**/*.xml";

    private String baseDaoPackage = "com.je.**.mapper";

    private boolean mapUnderscoreToCamelCase = true;

    public boolean isMapUnderscoreToCamelCase() {
        return mapUnderscoreToCamelCase;
    }

    public void setMapUnderscoreToCamelCase(boolean mapUnderscoreToCamelCase) {
        this.mapUnderscoreToCamelCase = mapUnderscoreToCamelCase;
    }

    public String getBaseDaoPackage() {
        return baseDaoPackage;
    }

    public void setBaseDaoPackage(String baseDaoPackage) {
        baseDaoPackage = baseDaoPackage;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

}
