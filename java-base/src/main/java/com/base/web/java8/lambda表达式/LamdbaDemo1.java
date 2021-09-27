package com.base.web.java8.lambda表达式;

import org.junit.Test;

public class LamdbaDemo1 {

    /**
     * 从匿名类到 Lambda 的转换
     */
    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Word");
            }
        };
        runnable.run();

        System.out.println("------------------------------------");

        Runnable runnable1 = () ->{
            System.out.println("Hello Lamdba");
        };
        runnable1.run();
    }
}
