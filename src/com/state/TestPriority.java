package com.state;

public class TestPriority implements Runnable{
    public static void main(String[] args) {
        TestPriority t1 = new TestPriority();

        TestPriority t2 = new TestPriority();
        TestPriority t3 = new TestPriority();
        TestPriority t4 = new TestPriority();
        Thread thread1 = new Thread(t1);
        thread1.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();

        System.out.println(Thread.currentThread().getName()+"------------->"+Thread.currentThread().getPriority());

    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"------------->"+Thread.currentThread().getPriority());

    }
}
