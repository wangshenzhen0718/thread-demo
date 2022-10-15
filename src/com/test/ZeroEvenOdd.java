package com.test;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {
    private static int n;
    private static Semaphore zeroSema = new Semaphore(1);
    private static Semaphore oddSema = new Semaphore(0);//奇数
    private static Semaphore evenSema = new Semaphore(0);//偶数

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(()->{
            for (int i1 = 1; i1 <= n; i1++) {
                try {
                    zeroSema.acquire();
                    printNum(0);
                    if((i1&1)==1){
                        oddSema.release();

                    }else{
                        evenSema.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        },"打印0").start();
        new Thread(()->{
            for (int i1 = 1; i1 <= n; i1++) {
                if((i1&1)==0){
                    try {
                        evenSema.acquire();
                        printNum(i1);
                        zeroSema.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        },"打印偶数").start();
        new Thread(()->{

            for (int i1 = 1; i1 <= n; i1++) {
                if((i1&1)==1){
                    try {
                        oddSema.acquire();
                        printNum(i1);
                        zeroSema.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        },"打印奇数").start();

    }

    public static void printNum(int i){
        System.out.print(i);
    }
}
