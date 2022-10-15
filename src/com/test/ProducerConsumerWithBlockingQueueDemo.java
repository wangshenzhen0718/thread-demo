package com.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Resource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public Resource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProducer() throws InterruptedException {
        String data = null;
        boolean retVal;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retVal = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retVal) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列：" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列：" + data + "失败");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void myConsumer() throws InterruptedException {
        String poll;
        while (FLAG) {
            poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (poll != null && poll != "") {
                System.out.println(Thread.currentThread().getName() + "\t 消费队列：" + poll + "成功");
            } else {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费队列失败");
            }
        }
    }
    public void stop() {
        this.FLAG = false;
    }
}

public class ProducerConsumerWithBlockingQueueDemo {
    public static void main(String[] args) {
        Resource resource = new Resource(new ArrayBlockingQueue<String>(10));
        new Thread(() -> {
            System.out.println("生产者线程启动");
            try {
                resource.myProducer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "生产者").start();

        new Thread(() -> {
            System.out.println("消费者线程启动");
            try {
                resource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }, "消费者").start();
        System.out.println("main线程分配");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("都停止！！！");
        resource.stop();
    }
}
