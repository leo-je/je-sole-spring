package com.je.cloud.mybatis.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@ConditionalOnClass({SqlSessionFactoryBean.class})
@EnableConfigurationProperties(MyBatisConfig.class)
@AutoConfigureBefore(MapperScannerAutoConfigurer.class)
@EnableTransactionManagement
public class MyBatisAutoConfigurer implements TransactionManagementConfigurer {

    @Autowired
    private DataSource dataSource;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MyBatisConfig myBatisConfig;

    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(this.dataSource);
    }

    @Bean(name = {"sqlSessionFactory"})
    public SqlSessionFactory sqlSessionFactoryBean() {
        try {
            log.info("-------------> SqlSessionFactory init");
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setTypeAliasesPackage(myBatisConfig.getTypeAliasesPackage());
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(myBatisConfig.getMapperPath());
            bean.setMapperLocations(resources);
            bean.setDataSource(this.dataSource);

            // 配置驼峰式命名
            bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);

            bean.setConfiguration(configuration(bean.getObject().getConfiguration()));

            return bean.getObject();
        } catch (Exception var4) {
            var4.printStackTrace();
            throw new RuntimeException(var4);
        }
    }

    //    @Bean
    public PageInterceptor paginationInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);

    }


    public Configuration configuration(Configuration configuration) {
        log.info("-------------> Mybatis customize init");
        //驼峰映射 a_book  -> aBook
        configuration.setMapUnderscoreToCamelCase(true);
        //禁止缓存
        configuration.setCacheEnabled(false);
        //值为null时不调用setter方法
        configuration.setCallSettersOnNulls(false);
        //添加自定义拦截器
        // 设置MyBatis分页插件
        PageInterceptor iterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        iterceptor.setProperties(properties);
        configuration.addInterceptor(iterceptor);
        return configuration;
    }
}
