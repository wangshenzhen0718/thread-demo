package com.syn;

import java.util.ArrayList;

public class UnsafeList  {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String>  integers = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->
            {
                synchronized (integers)
                {
                    integers.add(Thread.currentThread().getName());
                }

            }).start();
        }
        Thread.sleep(3000);



        System.out.println(integers.size());
    }


    }

