package com.base.juc.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description
 * @Author duanzm
 * @Date 2022/8/14 上午11:38
 * @Version 1.0
 **/
public class CallableDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<String>> futureList = new ArrayList<>();
        Callable<String> callable = new MyCallable();
        for(int i = 0; i < 10; i++){
            // 提交任务到线程池
            Future<String> future = threadPoolExecutor.submit(callable);
            // 将返回的结果添加到list中，通过future获得执行callback得到的返回值
            futureList.add(future);
        }

        for(Future<String> future: futureList){
            try {
                System.out.println(new Date() + "---" + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdown();
    }
}
