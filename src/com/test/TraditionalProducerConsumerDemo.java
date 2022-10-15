package com.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TraditionalProducerConsumerDemo {
    public static void main(String[] args) {
        ShareData1 shareData1 = new ShareData1();
        new Thread(()->{
            for (int i1 = 0; i1 < 5; i1++) {
                try {
                    shareData1.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"t1").start();

        new Thread(()->{
            for (int i1 = 0; i1 < 5; i1++) {
                try {
                    shareData1.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"t2").start();

    }
}

 class ShareData1{
    int num=0;
    private Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();
        while (num!=0){
            condition.await();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"\t"+num);
        condition.signalAll();
        lock.unlock();


    }

     public  void decrement() throws InterruptedException {
         lock.lock();
         while (num==0){
             condition.await();
         }
         num--;
         System.out.println(Thread.currentThread().getName()+"\t"+num);
         condition.signalAll();
         lock.unlock();


     }


}
