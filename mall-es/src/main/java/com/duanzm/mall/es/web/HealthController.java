package com.duanzm.mall.es.web;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 RestHighLevelClient 是否注入成功
 */
@RestController
public class HealthController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @RequestMapping("/health")
    public void health(){
        System.out.println("--------------------");
        System.out.println(restHighLevelClient); //打印出对象说明成功org.elasticsearch.client.RestHighLevelClient@33831e16
        System.out.println("--------------------");
    }

}
