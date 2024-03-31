package com.duanzm.redis.jedis;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

/**
 * 测试 Redis 连接是否正常
 */
public class HealthTest {

    // 1、注释掉bind
    public static void main(String[] args) {
        Jedis jc= new Jedis("127.0.0.1", 6379);
        jc.auth("redis123");
        String setResult = jc.set("SpringBoot-Redis", "health"); //向redis插入一条数据
        if("OK".equals(setResult)) {
            System.out.println("set success！");
        }
    }
}
