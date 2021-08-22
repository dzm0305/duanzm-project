package com.duanzm.mall.coupon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/coupon")
public class CouponController {

    @ResponseBody
    @RequestMapping("/index")
    public Map<String, Object> index(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "小张");
        map.put("age", "18");
        return map;
    }
}
