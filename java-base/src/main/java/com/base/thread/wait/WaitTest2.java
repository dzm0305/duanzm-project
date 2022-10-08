package com.base.thread.wait;

/**
 * @Description notify() 唤醒 wait()
 * @Author duanzm
 * @Date 2022/9/4 上午1:13
 * @Version 1.0
 **/
public class WaitTest2 {
    public static void main(String[] args) {
        new Thread(new TeacherThread(), "老师").start();
        new Thread(new KeDaiBiaoThread(), "课代表").start();
    }
}

/**
 * 体育老师
 */
class TeacherThread implements Runnable {

    @Override
    public void run() {
        synchronized (WaitTest2.class){
            // 体育老师安排体育课代表去点名
            System.out.println("1-体育老师让体育课代表去点名");
            try {
                // 体育老师等待点名结束
                WaitTest2.class.wait();
            }catch (Exception e){
               e.printStackTrace();
            }
            System.out.println("5-收到点名结果，开始上课");
        }
    }
}

/**
 * 体育课代表
 */
class KeDaiBiaoThread implements Runnable{

    @Override
    public void run(){
        synchronized (WaitTest2.class){
            System.out.println("2-体育课代表去点名");
            try{
                // 点名花费的时间
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("3-点名结束");
            // 如果不执行 notify() 的话，体育老师会一直等待
            WaitTest2.class.notify();
            System.out.println("4-课代表带学生去操场，并向老师汇报");
        }
    }
}
