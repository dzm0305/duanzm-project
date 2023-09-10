package com.base.web;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.Map;

public class TestController {
    public static void main(String[] args) {

        String s = "{\n" +
                "    \"code\": 1\n" +
                "}";
        Map<String, Object> ss = (Map<String, Object>) JSONUtils.parse(s);
        System.out.println("1");
    }
}
