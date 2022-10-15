package com.mydemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerWithBlockingQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            try {
                myResource.productor();
                System.out.println("\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产").start();

        new Thread(()->{
            try {
                myResource.consumer();
                System.out.println("\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myResource.stop();
        System.out.println("5s后退出");

    }
}

class MyResource {
    private volatile boolean FLAG=true;
    AtomicInteger atomicInteger=new AtomicInteger();
    private BlockingQueue<String> blockingQueue=null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void productor() throws InterruptedException {
        String data=null;
        boolean retVal=false;
        while (FLAG)
        {
            data=atomicInteger.incrementAndGet()+"";
             retVal = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retVal){
                System.out.println(Thread.currentThread().getName()+"插入队列"+data+"\t 成功");
            }else
            {
                System.out.println(Thread.currentThread().getName()+"插入队列"+data+"\t 失败");

            }
            try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

        }
        System.out.println("停止了");

    }
    public void consumer() throws InterruptedException {
        String retVal=null;
       while (FLAG)
       {
           retVal =blockingQueue.poll(2L,TimeUnit.SECONDS);
           if(retVal!=null&&retVal!="")
           {
               System.out.println(Thread.currentThread().getName()+"消费队列"+retVal+"\t 成功");
               System.out.println();
           }
           else
           {
               FLAG=false;
               System.out.println(Thread.currentThread().getName()+"消费队列"+retVal+"\t 失败");

           }


       }




    }
    public void  stop()
    {
        FLAG=false;
    }


}





