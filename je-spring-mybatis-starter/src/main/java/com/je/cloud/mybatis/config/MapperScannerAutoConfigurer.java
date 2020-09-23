package com.je.cloud.mybatis.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

public class MapperScannerAutoConfigurer {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        log.info("-------------> MyBatisMapperScannerConfig");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.je.**.mapper");//com.je.**.mapper
        return mapperScannerConfigurer;
    }
}
