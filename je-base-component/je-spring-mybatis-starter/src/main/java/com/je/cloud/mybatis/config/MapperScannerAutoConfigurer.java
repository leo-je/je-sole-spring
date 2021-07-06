package com.je.cloud.mybatis.config;

import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

public class MapperScannerAutoConfigurer {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private String baseDaoPackage = "**.mapper";

    /**
     * 无法通过配置文件引入baseDaoPackage参数
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(Environment environment) {
        log.info("-------------> MyBatisMapperScannerConfig ----- ");
        // 读取配置文件
        BindResult<MyBatisConfig> mybatisPropertiesBindResult = Binder.get(environment).bind(MyBatisConfig.CONFIG_PREFIX, MyBatisConfig.class);
        if (mybatisPropertiesBindResult != null && mybatisPropertiesBindResult.isBound()) {
            MyBatisConfig MyBatisConfig = mybatisPropertiesBindResult.get();
            if (MyBatisConfig != null && !StringUtils.isEmpty(MyBatisConfig.getBaseDaoPackage())) {
                baseDaoPackage = MyBatisConfig.getBaseDaoPackage();
            }
        }
        log.info("-------------> MyBatisMapperScannerConfig BasePackage:" + baseDaoPackage);
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(baseDaoPackage);//com.je.**.mapper
        return mapperScannerConfigurer;
    }
}
