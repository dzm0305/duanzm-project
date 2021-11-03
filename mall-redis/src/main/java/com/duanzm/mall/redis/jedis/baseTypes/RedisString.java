/*
package com.duanzm.mall.redis.jedis.baseTypes;

import com.duanzm.mall.redis.jedis.config.JedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

*/
/**
 * String类型 存取
 *//*

@Component
public class RedisString {

    @Autowired
    private JedisPool jedisPool;

    public void set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
            System.out.println("Redis 添加 " + key + " 成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    public void get(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            System.out.println("Redis中 " + key + " 值为：" + value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }
}
*/
