package com.je.cloud.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.docket.basePackage:com.je.cloud}")
    private String basePackage;

    @Value("${swagger2.docket.groupName:}")
    private String groupName;
    @Value("${swagger2.docket.apiInfo.title:je cloud base API Doc}")
    private String title;
    @Value("${swagger2.docket.apiInfo.version:1.0}")
    private String version;

    @Value("${swagger2.docket.apiInfo.description:}")
    private String description;

    @Bean
    @ConditionalOnMissingBean(Docket.class)
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(groupName).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any()).build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }

}