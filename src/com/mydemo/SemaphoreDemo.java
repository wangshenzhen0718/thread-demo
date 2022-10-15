package com.mydemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3,false);


        for (int i1 = 0; i1 < 6; i1++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"进来");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"出去");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();





            },String.valueOf(i1)).start();

        }

    }
}
