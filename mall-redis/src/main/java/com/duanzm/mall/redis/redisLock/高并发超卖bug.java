package com.duanzm.mall.redis.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
public class 高并发超卖bug {

    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * 场景一
     *  JDK锁如果是单机环境的话可以解决问题。如果是分布式架构，集群架构依然会有超卖问题。
     * @return
     */
    @RequestMapping("/deductStock")
    public String deductStock(){
        synchronized (this) {
            Integer stock = (Integer)redisTemplate.opsForValue().get("stock");// 初始化 在Redis中设置 stock = 200
            if (stock > 0) {
                int realStock = stock - 1;
                redisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减库存成功，当前剩余：" + realStock);
            } else {
                System.out.println("库存不足");
            }
        }
        return "end";
    }

    /**
     * 场景二
     *
     * @return
     */
    @RequestMapping("/deductStock2")
    public String deductStock2(){
        synchronized (this) {
            Integer stock = (Integer)redisTemplate.opsForValue().get("stock");// 初始化 在Redis中设置 stock = 200
            if (stock > 0) {
                int realStock = stock - 1;
                redisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减库存成功，当前剩余：" + realStock);
            } else {
                System.out.println("库存不足");
            }
        }
        return "end";
    }
}
