package com.duanzm.mall.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MallEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallEsApplication.class, args);
    }

}
