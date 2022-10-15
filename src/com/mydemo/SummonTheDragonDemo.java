package com.mydemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SummonTheDragonDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{

            System.out.println("召唤神龙！");
        });

        for (int i = 0; i < 7; i++) {
            final  int i1=i;
            new Thread(()->{
                System.out.println("收集到第"+i1+" 颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i1)).start();
        }

    }
}
