package com.duanzm.mall.redis.redisLock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class 高并发超卖bug {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 场景一
     *  JDK锁如果是单机环境的话可以解决问题。如果是分布式架构，集群架构依然会有超卖问题。
     */
    @RequestMapping("/deductStock")
    public String deductStock(){
        synchronized (this) {
            Integer stock = (Integer)redisTemplate.opsForValue().get("stock");// 初始化 在Redis中设置 stock = 200
            if (stock > 0) {
                int realStock = stock - 1;
                redisTemplate.opsForValue().set("stock", realStock);
                System.out.println("90扣减库存成功，当前剩余：" + realStock);
            } else {
                System.out.println("90库存不足");
            }
        }
        return "end";
    }

    /**
     * 场景二
     *  解决办法: 采用 redis 分布式锁
     *
     *  新的问题：
     *      这种情况下，如果第一个人使用的时候设置了 lockKey，中途出现了网络等卡顿问题，10秒之内没能处理完成，这个时候 lockKey 已经过期了。
     *      既然 lockKey 已经过期，那么第二个人就可以进行操作并设置了 lockKey。
     *      在第二个人正在处理程序的时候，第一个用户的程序执行完成了，开始执行 finally 中的删除操作，但此时它自己的已经过期了，删除的是第二个用户的 lockKey。
     *      久而久之就会导致 lockKey 一直被删除，锁失效的情况。
     */
    @RequestMapping("/deductStock2")
    public String deductStock2(){
        String lockKey = "produce_1";
        // Boolean existDzm = redisTemplate.opsForValue().setIfAbsent(lockKey, "dzm");// setnx() 只有在 key 不存在时设置
        // redisTemplate.expire(lockKey, 30, TimeUnit.SECONDS); // 定时
        // setnx和expire两个操作非原子性，expire操作之前程序崩溃，会发生死锁。为了保证设置 key 与过期时间的原子性。将两个命令合二为一。
        Boolean existDzm = redisTemplate.opsForValue().setIfAbsent(lockKey, "dzm", 10, TimeUnit.SECONDS);
        if(!existDzm){
            return "被占用";
        }
        try {
            Integer stock = (Integer) redisTemplate.opsForValue().get("stock");
            if (stock > 0) {
                int realStock = stock - 1;
                redisTemplate.opsForValue().set("stock", realStock);
                System.out.println("80扣减库存成功，当前剩余：" + realStock);
            } else {
                System.out.println("80库存不足");
            }
        }finally {
            redisTemplate.delete(lockKey);
        }
        return "end";
    }

    /**
     * 场景三
     *    解决办法：为了防止误删，我们在删除的时候进行判断，如果是自己的 lockKey 才可以进行删除( finally 中进行判断)。
     *
     *    新的问题：
     *      但是，在极端情况下， if(lockKey.equals(redisTemplate.opsForValue().get(lockKey))) 校验通过了，
     *      突然间卡顿造成第一个用户的 lockKey 过期了(未进行删除)，第二个用户进来后创建了自己的 lockKey
     *      此时第一个用户的网络正常了 开始执行删除操作，但是删除的缺是用户二的 lockKey。
     *      久而久之锁又一直被删除，造成锁失效的情况。
     */
    @RequestMapping("/deductStock3")
    public String deductStock3(){
        String lockKey = "produce_1";
        String uuid = UUID.randomUUID().toString(); // 后面要进行比较，所以不能写死
        Boolean existDzm = redisTemplate.opsForValue().setIfAbsent(lockKey, uuid, 30, TimeUnit.SECONDS);
        if(!existDzm){
            return "被占用";
        }
        try {
            Integer stock = (Integer) redisTemplate.opsForValue().get("stock");
            if (stock > 0) {
                int realStock = stock - 1;
                redisTemplate.opsForValue().set("stock", realStock);
                System.out.println("80扣减库存成功，当前剩余：" + realStock);
            } else {
                System.out.println("80库存不足");
            }
        }finally {
            // 判断是不是自己的锁
            if(uuid.equals(redisTemplate.opsForValue().get(lockKey))){
                redisTemplate.delete(lockKey);
            }
        }
        return "end";
    }

    /**
     * 场景四
     *    为了解决场景三的问题，引入"锁续命"：在主线程加锁成功后，开启一个分线程检查主线程是否持有这把锁，如果在 Redis 中还存在，将锁的时间重新设置为30（主线程结束的时候会将其删掉，分线程也就结束了）
     *    Redisson
     */
    @RequestMapping("/deductStock4")
    public String deductStock4(){
        String lockKey = "produce_1";
        // 获取分布式锁，只要锁的名字一样，就是同一把锁
        RLock redissonLock = redissonClient.getLock(lockKey);
        try {
            // 加锁（阻塞等待），默认过期时间是30秒
            redissonLock.lock();
            // 获取商品数量
            Integer stock = (Integer) redisTemplate.opsForValue().get("stock");
            if (stock > 0) {
                int realStock = stock - 1;
                redisTemplate.opsForValue().set("stock", realStock);
                System.out.println("80扣减库存成功，当前剩余：" + realStock);
            } else {
                System.out.println("80库存不足");
            }
        }finally {
            // 解锁
            redissonLock.unlock();
        }
        return "end";
    }
}
