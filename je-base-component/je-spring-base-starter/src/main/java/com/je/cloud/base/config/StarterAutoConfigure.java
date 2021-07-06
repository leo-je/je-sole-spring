package com.je.cloud.base.config;


import com.je.cloud.base.handle.ApplicationExceptionHandle;
import com.je.cloud.base.handle.PermissionHandler;
import com.je.cloud.base.utils.SpringContextHolder;
import org.springframework.context.annotation.Bean;

public class StarterAutoConfigure {


    @Bean
    PermissionHandler permissionHandler() {
        return new PermissionHandler();
    }

    @Bean
    ApplicationExceptionHandle applicationExceptionHandle() {
        return new ApplicationExceptionHandle();
    }

    @Bean
    SpringContextHolder springContextHolder(){
        return new SpringContextHolder();
    }
}
