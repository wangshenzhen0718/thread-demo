package com.atgu;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,5,
                1L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 1; i <=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行了");
                });
            }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {

        }


    }
}
