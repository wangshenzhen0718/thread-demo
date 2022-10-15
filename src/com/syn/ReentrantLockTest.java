package com.syn;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable{
    int tickets=10;
    private final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest,"1").start();
        new Thread(reentrantLockTest,"2").start();
        new Thread(reentrantLockTest,"3").start();

    }
    @Override
    public void run() {

        while (true)
        {

                try {
                    lock.lock();
                    if (tickets>0)
                    {
                        Thread.sleep(1000);
                        System.out.println(tickets--);

                    }
                    else break;


                }catch (Exception e)
                {
                    e.printStackTrace();
                }finally {
                    lock.unlock();

                }



        }

    }
}
