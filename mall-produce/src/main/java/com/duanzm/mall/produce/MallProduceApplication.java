package com.duanzm.mall.produce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.duanzm.mall.produce.feign")  // 开启远程调用功能
@EnableDiscoveryClient //开启服务注册与发现功能
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.duanzm.**.mapper")
public class MallProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProduceApplication.class, args);
    }

}
