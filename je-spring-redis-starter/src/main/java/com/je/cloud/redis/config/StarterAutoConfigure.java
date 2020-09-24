package com.je.cloud.redis.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


public class StarterAutoConfigure {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    @Primary
    //@ConditionalOnMissingBean(RedisTemplate.class)
    //@ConditionalOnBean(RedisConnectionFactory.class)
    public RedisTemplate<Object, Object> objectRedisTemplate(RedisConnectionFactory connectionFactory) {
        if (connectionFactory != null) {
            log.info("-------------> RedisTemplate init");
            RedisTemplate template = new RedisTemplate();
            template.setKeySerializer(new StringRedisSerializer());
            template.setHashKeySerializer(new StringRedisSerializer());
            template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
            template.setConnectionFactory(connectionFactory);
            return template;
        }
        return null;
    }

    @Bean
    //@ConditionalOnMissingBean(RedisTemplate.class)
    //@ConditionalOnBean(RedisConnectionFactory.class)
    public RedisTemplate<String, Object> stringRedisTemplate2(RedisConnectionFactory connectionFactory) {
        if (connectionFactory != null) {
            log.info("-------------> RedisTemplate init");
            RedisTemplate template = new RedisTemplate();
            template.setKeySerializer(new StringRedisSerializer());
            template.setHashKeySerializer(new StringRedisSerializer());
            template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
            template.setConnectionFactory(connectionFactory);
            return template;
        }
        return null;
    }

}
