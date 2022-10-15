package com.mydemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TraditionalProducerConsumerDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i1 = 0; i1 < 5; i1++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"t1").start();

        }
        for (int i1 = 0; i1 < 5; i1++) {
            new Thread(()->{
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"t2").start();

        }

    }
}

class ShareData{
    private int number=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void increment() throws InterruptedException {
        lock.lock();
        while (number!=0)
        {
            condition.await();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t "+number);
        condition.signalAll();
        lock.unlock();

    }

    public void decrement() throws InterruptedException {
        lock.lock();
        while (number==0)
        {
            condition.await();
        }
        number-- ;
        System.out.println(Thread.currentThread().getName()+"\t "+number);
        condition.signalAll();
        lock.unlock();




    }






}