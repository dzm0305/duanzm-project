package com.duanzm.mall.redis.redisTemplate.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redissons 配置类
 */
@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://121.196.210.187:16379").setPassword("redis123");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
