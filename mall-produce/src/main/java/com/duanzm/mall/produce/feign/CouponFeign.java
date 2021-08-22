package com.duanzm.mall.produce.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient("mall-coupon") // 与注册中心名称一致
public interface CouponFeign {

    @RequestMapping("/coupon/index")
    public Map<String, Object> index();
}
