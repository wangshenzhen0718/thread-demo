package com.mydemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareDate1 shareDate1 = new ShareDate1();
        int num=10;
        for (int i1 = 0; i1 < num; i1++) {
            new Thread(()->{
                try {
                    shareDate1.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"A").start();
        }
        for (int i1 = 0; i1 < num; i1++) {
            new Thread(()->{
                try {
                    shareDate1.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"B").start();
        }

        for (int i1 = 0; i1 < num; i1++) {
            new Thread(()->{
                try {
                    shareDate1.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"C").start();
        }
    }
}

class ShareDate1{
    private int number=1;
    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();
    public void print5() throws InterruptedException {
        lock.lock();
        while(number!=1)
        {
            condition1.await();
        }
        for (int i1 = 0; i1 < 5; i1++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i1);
        }
        number=2;
        condition2.signal();
        lock.unlock();
    }

    public void print10() throws InterruptedException {
        lock.lock();
        while(number!=2)
        {
            condition2.await();
        }
        for (int i1 = 0; i1 < 10; i1++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i1);
        }
        number=3;
        condition3.signal();
        lock.unlock();
    }
    public void print15() throws InterruptedException {
        lock.lock();
        while(number!=3)
        {
            condition3.await();
        }
        for (int i1 = 0; i1 < 15; i1++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i1);
        }
        number=1;
        condition1.signal();
        lock.unlock();
    }
}