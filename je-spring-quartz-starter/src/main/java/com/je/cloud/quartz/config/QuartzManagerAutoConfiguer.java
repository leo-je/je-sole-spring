package com.je.cloud.quartz.config;

import com.je.cloud.quartz.service.TaskService;
import com.je.cloud.quartz.utils.QuartzManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;


@ConditionalOnBean(TaskService.class)
public class QuartzManagerAutoConfiguer {

    @Bean
    public QuartzManager quartzManager() {
        return new QuartzManager();
    }
}
