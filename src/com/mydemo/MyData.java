package com.mydemo;

import java.util.concurrent.TimeUnit;

public class MyData {//原子性代码
    public volatile int number=0;
    public void add_to_60(){
        this.number=number+60;
    }
}

class VolatileDemo{
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
            myData.add_to_60();
            System.out.println(myData.number);

        },"AAA").start();

        new Thread(()->{
            myData.number=myData.number+10;
            System.out.println(myData.number);
        },"BBB").start();




    }



}