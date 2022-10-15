package com.atgu;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {


    AtomicReference<Thread> atomicReference=new AtomicReference<Thread>();
    private void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"come in");
       // atomicReference.compareAndSet(null,thread);
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    private void myunlock(){
        Thread thread = Thread.currentThread();

        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"come out");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(
                ()->{
                    spinLockDemo.mylock();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    spinLockDemo.myunlock();

                }
        ,"t1").start();
        Thread.sleep(1000);
        new Thread(
                ()->{
                    spinLockDemo.mylock();
                    spinLockDemo.myunlock();

                }
                ,"t2").start();

    }
}
