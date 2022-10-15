package com.mydemo;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData2 {//原子性
    volatile int number=0;
    AtomicInteger atomicInteger=new AtomicInteger();
    public void addPlusPlus() {
        number ++;
    }
    public void addPlusPlus2(){
        atomicInteger.getAndIncrement();
    }
}
class VolatileAtomicityDemo {
    public static void main(String[] args) {
        MyData2 myData = new MyData2();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    myData.addPlusPlus();
                    myData.addPlusPlus2();
                }
            },"AAA").start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"   最终值："+myData.number);
        System.out.println(Thread.currentThread().getName()+"   最终值："+myData.atomicInteger);
    }
}