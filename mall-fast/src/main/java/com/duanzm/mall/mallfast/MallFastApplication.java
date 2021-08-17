package com.duanzm.mall.mallfast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MallFastApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallFastApplication.class, args);
    }

}
