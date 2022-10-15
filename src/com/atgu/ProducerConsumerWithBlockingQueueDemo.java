package com.atgu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean FLAG=true;
    AtomicInteger atomicInteger=new AtomicInteger();
    BlockingQueue<String> blockingQueue=null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("传入了---"+blockingQueue.getClass().getName());
    }

    public void myProducer() throws Exception{

        String date=null;
        boolean retVal;
        while (FLAG){
            date=atomicInteger.incrementAndGet()+"";
            retVal=blockingQueue.offer(date,2L,TimeUnit.SECONDS);
            if (retVal)
            {
                System.out.println(Thread.currentThread().getName()+date+"  插入成功");
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+date+"  插入失败");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产，表示FLAG=false，生产结束");




    }

    public void myConsumer() throws Exception{

        String result=null;

        while (FLAG){
            result=blockingQueue.poll(2,TimeUnit.SECONDS);


            if (result!=null&&result!="")
            {
                System.out.println(Thread.currentThread().getName()+result+"  取出成功");
            }
            else
            {
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"\t消费失败，队列中已为空，退出");
                return;
            }

        }

    }

    public void stop(){
        FLAG=false;
    }


}
public class ProducerConsumerWithBlockingQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动\n\n");
            try {
                myResource.myProducer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"producer").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动\n\n");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n5秒中后，生产和消费线程停止，线程结束");
        myResource.stop();


    }
}