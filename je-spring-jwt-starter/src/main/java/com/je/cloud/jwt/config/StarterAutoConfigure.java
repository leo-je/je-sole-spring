package com.je.cloud.jwt.config;


import com.je.cloud.jwt.interceptor.TokenInterceptor;
import com.je.cloud.jwt.service.JwtService;
import com.je.cloud.jwt.service.impl.JwtServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@ConditionalOnClass(JwtService.class)
@EnableConfigurationProperties(JwtConfig.class)
public class StarterAutoConfigure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * ConditionalOnBean 当容器中有指定的Bean的条件下
     * ConditionalOnClass 当类路径下有指定的类的条件下
     * ConditionalOnExpression:基于SpEL表达式作为判断条件
     * ConditionalOnJava:基于JVM版本作为判断条件
     * ConditionalOnJndi:在JNDI存在的条件下查找指定的位置
     * ConditionalOnMissingBean:当容器中没有指定Bean的情况下
     * ConditionalOnMissingClass:当类路径下没有指定的类的条件下
     * ConditionalOnNotWebApplication:当前项目不是Web项目的条件下
     * ConditionalOnProperty:指定的属性是否有指定的值
     * ConditionalOnResource:类路径下是否有指定的资源
     * ConditionalOnSingleCandidate:当指定的Bean在容器中只有一个，或者在有多个Bean的情况下，用来指定首选的Bean
     * ConditionalOnWebApplication:当前项目是Web项目的条件下
     */

    @Resource
    JwtConfig jwtConfig;

    @Bean
    @ConditionalOnMissingBean(JwtService.class)
    /**
     * @ConditionalOnProperty(prefix = "je.jwt", value = "enabled", havingValue = "true",matchIfMissing = true)
     */
    public JwtService starterService() {
        if (jwtConfig.isEnabled()) {
            log.info("-------------> JwtService init");
            return new JwtServiceImpl();
        }
        return null;
    }

    @Bean
    @ConditionalOnMissingBean(TokenInterceptor.class)
    TokenInterceptor tokenInterceptor() {
        log.info("-------------> tokenInterceptor init");
        return new TokenInterceptor();
    }
}
