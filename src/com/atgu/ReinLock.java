package com.atgu;

public class ReinLock implements Runnable{
    public synchronized void get(){
        System.out.println(Thread.currentThread().getName()+"--------get");
        set();


    }
    public synchronized void set(){
        System.out.println(Thread.currentThread().getName()+"--------set");


    }


    @Override
    public void run() {
        get();
    }
}

class Test{
    public static void main(String[] args) {
        ReinLock reinLock = new ReinLock();
        new Thread(reinLock,"t1").start();
        new Thread(reinLock,"t2").start();

    }
}