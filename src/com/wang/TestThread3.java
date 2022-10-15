package com.wang;

import java.util.concurrent.atomic.AtomicInteger;

public class TestThread3 implements Runnable{
    //private static int tickets=10;
    private static AtomicInteger integer=new AtomicInteger(10);

    @Override
    public void run() {

        while(integer.get()>0){
            System.out.println(Thread.currentThread().getName()+"买到了第--"+integer.getAndDecrement()+"张票");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }





        }

    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3,"小明").start();
        new Thread(testThread3,"老师").start();
        new Thread(testThread3,"黄牛党").start();
    }

}
