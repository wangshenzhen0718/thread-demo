package com.syn;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnsafeList1 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String>  integers = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->
            {
                    integers.add(Thread.currentThread().getName());

            }).start();
        }
        Thread.sleep(3000);



        System.out.println(integers.size());
    }


    }

