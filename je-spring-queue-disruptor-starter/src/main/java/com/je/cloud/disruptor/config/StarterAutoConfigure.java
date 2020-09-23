package com.je.cloud.disruptor.config;


import com.je.cloud.disruptor.component.DisruptorComponent;
import com.je.cloud.disruptor.service.DisruptorService;
import com.je.cloud.disruptor.service.impl.DisruptorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DisruptorConfig.class)
public class StarterAutoConfigure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    @ConditionalOnMissingBean(DisruptorComponent.class)
    DisruptorComponent disruptorComponent() {
        log.info("-------------> disruptorComponent init");
        return new DisruptorComponent();
    }


    @Bean
    @ConditionalOnMissingBean(DisruptorService.class)
    @ConditionalOnBean(DisruptorComponent.class)
    DisruptorService disruptorService() {
        log.info("-------------> disruptorService init");
        return new DisruptorServiceImpl();
    }

}
