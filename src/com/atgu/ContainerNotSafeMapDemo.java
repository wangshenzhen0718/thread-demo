package com.atgu;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeMapDemo {
    public static void main(String[] args) {


        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 50; i++) {
            new Thread(
                    ()->{
                        map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                        System.out.println(Thread.currentThread().getName() +map);

                    }
            ,String.valueOf(i)).start();
        }

    }
}
