package com.je.cloud.busi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

//@Configuration
//@ConditionalOnClass({SqlSessionFactoryBean.class})
//@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource dataSource;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public MyBatisConfig() {
    }

    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(this.dataSource);
    }

    @Bean(
            name = {"sqlSessionFactory"}
    )
    public SqlSessionFactory sqlSessionFactoryBean() {
        try {
            System.out.println("SqlSessionFactory");
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//            bean.setTypeAliasesPackage(this.getDomainPath("com/je/cloud"));
            bean.setTypeAliasesPackage("com.je.**.entity");
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath*:com/je/cloud/**/*.xml");
            bean.setMapperLocations(resources);
            bean.setDataSource(this.dataSource);
            return bean.getObject();
        } catch (Exception var4) {
            var4.printStackTrace();
            throw new RuntimeException(var4);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
