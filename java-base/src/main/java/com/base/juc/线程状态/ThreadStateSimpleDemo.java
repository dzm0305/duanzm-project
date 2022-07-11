package com.base.juc.线程状态;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * @author duanzhimin
 */
public class ThreadStateSimpleDemo {

    // 每个线程执行的次数
    public static final long MAX_TURN = 5;

    // 线程编号
    static int threadSeqNumber = 0;

    // 全局的静态线程列表
    static List<Thread> threadList = new ArrayList<Thread>();

    // 输出静态线程列表中每个线程的状态
    private static void printThreadState() {
        for (Thread thread: threadList){
            System.out.println(thread.getName() + "状态为：" + thread.getState());
        }
    }

    // 向全局的静态线程列表加入线程
    private static void addStatusThread(Thread thread) {
        threadList.add(thread);
    }

    static class StatusDemoThread extends Thread{
        public StatusDemoThread(){
            super("statusPrintThread" + (++threadSeqNumber));
            // 将自己加入全局的静态线程列表
            threadList.add(this);
        }

        @Override
        public void run() {
            System.out.println(getName() + ",状态为" + getState());
            for(int i = 0; i < MAX_TURN; i++){
                // 线程睡眠
                LockSupport.parkNanos(500 * 1000L * 1000L);
                // 输出所有线程状态
                printThreadState();
            }
        }

        public static void main(String[] args) {
            // 将main线程加入全局列表
            addStatusThread(Thread.currentThread());
            // 新建三个线程，将这些线程在构造器中会将自己加入全局列表
            Thread thread1 = new StatusDemoThread();
            System.out.println(thread1.getName() + "状态为" + thread1.getState());
            Thread thread2 = new StatusDemoThread();
            System.out.println(thread2.getName() + "状态为" + thread2.getState());
            Thread thread3 = new StatusDemoThread();
            System.out.println(thread3.getName() + "状态为" + thread3.getState());
            // 启动第一个线程
            thread1.start();
            // 等待500毫秒启动第二个线程
            LockSupport.parkNanos(500 * 1000L * 1000L);
            thread2.start();
            // 等待500毫秒启动第三个线程
            LockSupport.parkNanos(500 * 1000L * 1000L);
            // 睡眠100秒
            LockSupport.parkNanos(100 * 1000L * 1000L);
        }
    }
}
