package com.state;

public class TestDaemon implements Runnable{



    public static void main(String[] args) {
        TestDaemon testDaemon = new TestDaemon();
        Thread thread = new Thread(testDaemon);
        thread.setDaemon(true);
        thread.start();


        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心的活着！！！");
        }
        System.out.println("good bye!!!");

    }
    @Override
    public void run() {
        while(true){
            System.out.println("上帝守护你");
        }

    }
}
