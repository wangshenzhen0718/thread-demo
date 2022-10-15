package com.state;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip来了"+i);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();

        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i < 200; i++) {
            if(i==100)
                thread.join();
            System.out.println("main"+i);

        }
    }

}
