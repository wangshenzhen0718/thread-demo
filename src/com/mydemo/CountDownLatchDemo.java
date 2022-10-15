package com.mydemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            final int i1=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 上完课离开教室");
                countDownLatch.countDown();
            },String.valueOf(i1)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长离开教室");

    }
}
