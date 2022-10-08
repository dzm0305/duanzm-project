package com.base.thread.interrupt;

import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 如果线程在运行中，interrupt()只会设置线程的中断标志，没有其他任何作用。
 * @Author duanzm
 * @Date 2022/9/4 上午10:25
 * @Version 1.0
 **/

public class InterruptTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread interruptThread = new InterruptThread();
        interruptThread.start();
        // 等到main线程睡眠对应时间后，就在thread线程进行标记，Thread.currentThread().isInterrupted()变为true；
        // 标记之后，线程循环判断线程是否为非true，也就是false，如果是false，则跳出循环；这样就达到了线程的停止
        Thread.sleep(1000);
        interruptThread.interrupt();
    }
}

class InterruptThread extends Thread{

    @Override
    public void run() {
        try{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("--------- 1 ------");
            }
            System.out.println("--------- 2 ------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
