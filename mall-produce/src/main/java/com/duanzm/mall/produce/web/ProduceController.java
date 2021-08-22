package com.duanzm.mall.produce.web;

import com.duanzm.mall.produce.feign.CouponFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/produce")
public class ProduceController {

    @Autowired
    private CouponFeign couponFeign;

    @ResponseBody
    @RequestMapping("/index")
    public Map<String, Object> index(){
        Map<String, Object> map = couponFeign.index();
        map.put("pet", "dog");
        return map;
    }
}
