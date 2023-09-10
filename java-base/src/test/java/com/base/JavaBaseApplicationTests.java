package com.base;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaBaseApplicationTests {

    private final String[] sfopOldKeys = {"ENVIRONMENTAL_PROBLEM_TYPE", "IS_VERTICAL_RECTIFICATION", "VERTICAL_RECTIFICATION_DESC"};

    @Test
    void contextLoads() {
        // System.out.println(ArrayUtils.indexOf(sfopOldKeys, "IS_VERTICAL_RECTIFICATION"));

        String originalUrl = "http://10.1.50.153:88/itsmApp/upload/file/47d285cd25f94c428a4062f80c7dab04.pdf";
        if(originalUrl.contains("10.1.50.153:88")) {
            String replace1 = originalUrl.replace("172.25.80.154:8081", "10.1.50.153:88");
            String replace2 = originalUrl.replace( "10.1.50.153:88", "172.25.80.154:8081");
            // System.out.println(replace2);
        }


        String str = "1234567890、";
        System.out.println(str.substring(0, str.length() - 1));


        System.out.println("开始");
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
            if(i == 5){
                break;
            }
        }
        System.out.println("结束");




    }

}
