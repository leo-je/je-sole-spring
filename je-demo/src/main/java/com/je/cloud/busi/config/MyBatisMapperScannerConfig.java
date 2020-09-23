package com.je.cloud.busi.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ConditionalOnClass({SqlSessionFactoryBean.class})
public class MyBatisMapperScannerConfig {
    public MyBatisMapperScannerConfig() {
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        System.out.println("MyBatisMapperScannerConfig");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage(this.getMapperPath("com/je/cloud"));
        mapperScannerConfigurer.setBasePackage("com.je.**.mapper");//com.je.**.mapper
        return mapperScannerConfigurer;
    }
}
