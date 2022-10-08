package com.base;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaBaseApplicationTests {

    private final String[] sfopOldKeys = {"ENVIRONMENTAL_PROBLEM_TYPE", "IS_VERTICAL_RECTIFICATION", "VERTICAL_RECTIFICATION_DESC"};

    @Test
    void contextLoads() {
        System.out.println(ArrayUtils.indexOf(sfopOldKeys, "IS_VERTICAL_RECTIFICATION"));

        System.out.println("124534567890-");
    }

}
