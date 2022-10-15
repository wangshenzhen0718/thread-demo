package com.state;

public class TestYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行!!");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"结束执行！！！！");
    }

    public static void main(String[] args) {
        TestYield testYield = new TestYield();
        new Thread(testYield,"a").start();
        new Thread(testYield,"b").start();

    }
}
