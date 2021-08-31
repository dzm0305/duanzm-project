package com.duanzm.mall.produce.web;

import com.duanzm.mall.produce.entity.CategoryEntity;
import com.duanzm.mall.produce.feign.CouponFeign;
import com.duanzm.mall.produce.service.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 商品
 */

@Controller
@RequestMapping("/produce")
public class ProduceController {

    @Autowired
    private CouponFeign couponFeign;

    @Autowired
    private IProduceService produceService;

    /**
     * 测试Nacos-feign远程调用
     * @return
     */

    @ResponseBody
    @RequestMapping("/index")
    public Map<String, Object> index(){
        Map<String, Object> map = couponFeign.index();
        map.put("pet", "dog");
        return map;
    }

    @ResponseBody
    @RequestMapping("/tree")
    public List<CategoryEntity> tree(){
        List<CategoryEntity> tree = produceService.tree();
        return tree;
    }
}