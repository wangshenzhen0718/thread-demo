package com.mydemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueBlockedDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        new Thread(()->{
            try {
                arrayBlockingQueue.put("1");
                arrayBlockingQueue.put("2");
                arrayBlockingQueue.put("3");
                arrayBlockingQueue.put("3");
                System.out.println("阻塞中。。。。。。。。。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println("阻塞中。。。。。。。。。。。。");
        System.out.println(arrayBlockingQueue.take());



    }
}
