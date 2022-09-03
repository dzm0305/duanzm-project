package com.base.juc.callable;

import java.util.concurrent.Callable;

/**
 * @Description
 * @Author duanzm
 * @Date 2022/8/14 上午11:37
 * @Version 1.0
 **/
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
