package com.base.thread.wait;

import net.sf.jsqlparser.statement.select.Wait;

/**
 * @Description wait() 是会释放锁的,但是线程下一步操作却被挂起了
 * @Author duanzm
 * @Date 2022/9/4 上午12:30
 * @Version 1.0
 **/
public class WaitTest1 {
    public static void main(String[] args) {
        WaitThread waitThread = new WaitThread();

        Thread thread1 = new Thread(waitThread, "线程1");
        Thread thread2 = new Thread(waitThread, "线程2");
        Thread thread3 = new Thread(waitThread, "线程3");
        Thread thread4 = new Thread(waitThread, "线程4");
        Thread thread5 = new Thread(waitThread, "线程5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

class WaitThread implements Runnable{

    private Object lock = new Object();

    @Override
    public void run() {
        try {
            synchronized (lock){
                System.out.println("开始----" + Thread.currentThread().getName() );
                lock.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("结束--------" + Thread.currentThread().getName());
    }
}
