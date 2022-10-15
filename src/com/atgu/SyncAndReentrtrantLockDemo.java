package com.atgu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareDate2{
    private int nums=1;
    Lock lock=new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public void print5(){
        lock.lock();
        try {
            while (nums!=1)
            {
                condition1.await();

            }
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+i);
            }
            nums=2;
            condition2.signal();

        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            while (nums!=2)
            {
                condition2.await();

            }
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+i);
            }
            nums=5;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while (nums!=5)
            {
                condition3.await();

            }
            for (int i = 15; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+i);
            }
            nums=1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
public class SyncAndReentrtrantLockDemo {
    public static void main(String[] args) {
        ShareDate2 shareDate2 = new ShareDate2();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                shareDate2.print5();
            }


        },"A").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                shareDate2.print10();
            }


        },"B").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                shareDate2.print15();
            }


        },"C").start();
    }
}
