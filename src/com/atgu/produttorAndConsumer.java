package com.atgu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
class ShareDate1{
    private int num=0;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num!=0)
            {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"==="+num);
            condition.signalAll();
            condition.signalAll();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }

    }
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num==0)
            {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"==="+num);
            condition.signalAll();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }

    }





}
public class produttorAndConsumer {


    public static void main(String[] args) {
        ShareDate1 shareDate1 = new ShareDate1();


        new Thread(
                ()->{
                    for (int i = 5; i > 0; i--) {
                        try {
                            shareDate1.increment();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }



                }
                ,"t1"
        ).start();

        new Thread(
                ()->{
                    for (int i = 5; i > 0; i--) {
                        try {
                            shareDate1.decrement();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }



                }
                ,"t2"
        ).start();



    }
}
