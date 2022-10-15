package com.atgu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SyncBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "\t put A ");
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put B ");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put C ");
                queue.put("3");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "AAA").start();
        new Thread(()->{

            try {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.take();
                System.out.println(Thread.currentThread().getName() + "\t take A ");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.take();
                System.out.println(Thread.currentThread().getName() + "\t take B ");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.take();
                System.out.println(Thread.currentThread().getName() + "\t take C ");
            } catch (Exception e) {
              e.printStackTrace();
            } finally {

            }
        }).start();


    }

}
