package com.atgu;

import java.util.concurrent.TimeUnit;

public class MyData {
    volatile int a=10;
    public void add(){
        a=60;
    }
}
class VolatileDemo{

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName()+"come in/n");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    myData.add();
                }

       ,"AAA" ).start();
        while(myData.a==10){}
        System.out.println(Thread.currentThread().getName()+" over/n"+myData.a);

    }



}