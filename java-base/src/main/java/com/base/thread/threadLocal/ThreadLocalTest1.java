package com.base.thread.threadLocal;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author duanzm
 * @Date 2022/9/5 上午12:32
 * @Version 1.0
 **/
public class ThreadLocalTest1 {

    /*private String msg;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }*/

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public String getMsg() {
        return threadLocal.get();
    }
    public void setMsg(String msg) {
        threadLocal.set(msg);
    }

    public static void main(String[] args) {
        int countNum = 9;
        ThreadLocalTest1 threadLocalTest1 = new ThreadLocalTest1();
        CountDownLatch countDownLatch = new CountDownLatch(countNum);
        for(int i = 0; i < countNum; i++) {
            Thread thread = new Thread(() -> {
                threadLocalTest1.setMsg(Thread.currentThread().getName());
                System.out.println("----------------" + threadLocalTest1.getMsg());
                countDownLatch.countDown();
            }, "thread" + i);
            thread.start();
        }
    }

}
