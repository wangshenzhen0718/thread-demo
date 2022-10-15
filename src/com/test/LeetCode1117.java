package com.test;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class LeetCode1117 {

    public static void main(String[] args) {
        H2O h2o = new H2O();

        String waters = new Scanner(System.in).next();

        for (int i = 0; i < waters.length(); i++) {
            int finalI = i;
            new Thread(()->{
                if(waters.charAt(finalI)=='H'){
                    try {
                        h2o.hydrogen(()->System.out.print("H"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if(waters.charAt(finalI)=='O'){
                    try {
                        h2o.oxygen(()->System.out.print("O"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    throw new RuntimeException("'water' must consist of values in ['H', 'O'] only");
                }
            }).start();
        }
    }
}

class H2O {

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(2);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        h.acquire();

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();

        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        o.acquire(2);

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();

        h.release(2);
    }

}