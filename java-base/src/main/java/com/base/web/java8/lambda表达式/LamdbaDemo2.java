package com.base.web.java8.lambda表达式;

import org.junit.Test;

/**
 *  作为参数传递Lamdba表达式：为了将Lamdba表达式作为参数传递，接受Lamdba表达式的参数类型必须是该Lamdba表达式兼容的函数式接口
 */
public class LamdbaDemo2 {

    public String toUpperString(String str, MyFunc<String> mf){
        String s = "";
        if(!str.isEmpty()){
            s = mf.getValue(str);
        }
        return s;
    }

    @Test
    public void test1(){
        String s = toUpperString("sdf", new MyFunc<String>() {
            @Override
            public String getValue(String s) {
                String s1 = s.toUpperCase();
                return s1;
            }
        });
        System.out.println(s);

        System.out.println("----------------");

        String s2 = toUpperString("ADS", (str) -> str.toLowerCase());
        System.out.println(s2);
    }
}
