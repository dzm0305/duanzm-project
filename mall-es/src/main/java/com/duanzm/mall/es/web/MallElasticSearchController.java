package com.duanzm.mall.es.web;

import com.alibaba.fastjson.JSON;
import com.duanzm.mall.es.config.MallElasticSearchConfig;
import com.duanzm.mall.es.entity.Pet;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/es")
public class MallElasticSearchController {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 创建索引，
     * 保存更新数据
     * @throws IOException
     */
    @RequestMapping("/insertIndex")
    public void insertIndex() throws IOException {
        IndexRequest indexRequest = new IndexRequest("pet");
        indexRequest.id("003");
        //Pet pet = new Pet();
        Pet pet = new Pet("小狗", 12, "公");
        String petJson = JSON.toJSONString(pet);
        //保存数据
        indexRequest.source(petJson, XContentType.JSON);
        IndexResponse index = client.index(indexRequest, MallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);

    }
}
