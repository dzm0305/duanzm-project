package com.base.web.thread;


/**
 * 子线程执行10次后，主线程再运行5次，这样交替执行三遍
 */
public class ThreadTestController {

    public static void main(String[] args) {
        final Bussiness bussiness= new Bussiness();
        //创建一个子线程,run方法里面子线程执行3变
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 3; i++){
                    bussiness.subMethod();
                }
            }
        }).start();

        for(int i = 0; i < 3 ; i++){
            bussiness.mainMethod();
        }
    }
}


class Bussiness{

    private Boolean flag = true;

    public synchronized void mainMethod(){
        //标识为true 就等待，释放所持有的锁，让另一个线程执行，直到被唤醒才继续执行下去
        while(flag){
            try{
                //wait()的作用是让当前线程进入等待状态，同时wait()也会让当前线程释放他所有的锁
                //直到其他线程调用此对象的 notify()或者notify()方法，当前线程被唤醒进入"就绪状态"
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //如果当前的标志位不为true，就向下执行
        for(int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + "main thread run " + i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        flag = true;
        //唤醒当前对象上的等待线程
        notify();
    }

    public synchronized void subMethod(){
        //如果标识为 false 则执行等待，让另一个线程执行，直到被唤醒
        while(!flag){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // 如果标示为true， 则执行循环
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "sub Thread run" + i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            //执行完一个循环后就将标识为改为false，防止这个线程连续两次执行
            flag = false;
            notify();
        }
    }
}

