package com.base.thread.join;

import org.slf4j.LoggerFactory;

/**
 * @Description join() 方法用于等待线程的终止，与 wait()、notify() 方法一起，用于实现线程间的同步机制
 * @Author duanzm
 * @Date 2022/9/4 上午9:59
 * @Version 1.0
 **/
public class JoinTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread joinThread = new JoinThread(2);
        joinThread.start();
        System.out.println("2、准备进入 join()");
        joinThread.join();
        System.out.println("5、main end");
        System.out.println("joinThread是否存活" + joinThread.isAlive());
    }
}

class JoinThread extends Thread{

    public int countNum = 0;

    public JoinThread(int countNum) {
        this.countNum = countNum;
        System.out.println("1、创建线程");
    }

    @Override
    public void run() {
        System.out.println("3、线程开始");
        while (countNum > 0){
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            countNum--;
        }
        System.out.println("4、线程运行结束");
    }
}
