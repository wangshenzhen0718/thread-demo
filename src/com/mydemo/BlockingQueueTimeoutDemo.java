package com.mydemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTimeoutDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println("offer");
        System.out.println(queue.offer("1",2L, TimeUnit.SECONDS ));
        System.out.println(queue.offer("2",2L, TimeUnit.SECONDS ));
        System.out.println(queue.offer("3",2L, TimeUnit.SECONDS ));
        System.out.println(queue.offer("4",2L, TimeUnit.SECONDS ));



        System.out.println("poll");
        System.out.println(queue.poll(2L, TimeUnit.SECONDS ));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS ));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS ));
        System.out.println(queue.poll(2L, TimeUnit.SECONDS ));

    }
}
