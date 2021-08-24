package com.duanzm.mall.coupon.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@Controller
@RequestMapping("/coupon")
public class CouponController {

    @Value("${coupon.user.name}")
    private String name;

    @Value("${coupon.user.age}")
    private Integer age;

    @ResponseBody
    @RequestMapping("/index")
    public Map<String, Object> index(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("age", age);
        return map;
    }
}
