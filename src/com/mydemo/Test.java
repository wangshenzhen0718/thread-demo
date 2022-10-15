package com.mydemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Test {
    public static void main(String[] args) {

        AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);

        },"AAA").start();

        new Thread(()->{
            try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

            System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());


        },"BBB").start();

    }
}
