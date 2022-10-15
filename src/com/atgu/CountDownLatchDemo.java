package com.atgu;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(
                    ()->{
                        System.out.println(Thread.currentThread().getName()+"\t被灭");
                        countDownLatch.countDown();
                    }
                    ,CountryEnum.forEach_country(i).getRetMessage()
            ).start();
        }
       countDownLatch.await();
        System.out.println("秦国一统天下");
    }
}
