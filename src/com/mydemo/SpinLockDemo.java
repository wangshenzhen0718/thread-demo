package com.mydemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.currentThread;

public class SpinLockDemo {

    AtomicReference<Thread> atomicReference=new AtomicReference<>();



    public void myLock(){
        Thread thread =  Thread.currentThread();
        System.out.println(currentThread().getName()+"\t come in!");

        while (!atomicReference.compareAndSet(null,thread))
        {

        }



    }

    public void myUnlock(){

        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(currentThread().getName()+"\t invoke myUnlock!");
    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
            spinLockDemo.myUnlock();


        },"t1").start();
        try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

        // 1秒后，启动t2线程，开始占用这个锁
        new Thread(() -> {

            // 开始占有锁
            spinLockDemo.myLock();
            // 开始释放锁
            spinLockDemo.myUnlock();

        }, "t2").start();


    }
}
