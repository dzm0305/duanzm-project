package com.base.web.thread;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLoadTest implements Runnable{

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLoadTest threadLoadTest = new ThreadLoadTest();
        for(int i = 0; i < 10; i++){
            Thread t = new Thread(threadLoadTest, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + "default Formatter = " + formatter.get().toPattern());
        try{
            Thread.sleep(new Random().nextInt(1000));
        }catch (Exception e){
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());
        System.out.println("THread Name= " + Thread.currentThread().getName() + "formatter=" + formatter.get().toPattern());
    }
}
