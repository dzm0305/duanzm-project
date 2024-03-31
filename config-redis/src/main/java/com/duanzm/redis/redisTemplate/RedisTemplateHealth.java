package com.duanzm.redis.redisTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RedisTemplateHealth {

    @Autowired
    public RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("/health/test")
    public String test(){
        redisTemplate.opsForValue().set("redisTemplate", "health");
        return "success";
    }
}
