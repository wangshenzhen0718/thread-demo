package com.mydemo;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //Vector<String> list = new Vector<>();
        //CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);

            },String.valueOf(i)).start();
        }
    }
}
