package com.mydemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapNotSafeDemo {

    public static void main(String[] args) {
        //HashMap map = new HashMap<String,String>();
        //Map map = new ConcurrentHashMap();
        //Map map = Collections.synchronizedMap(new HashMap<String,String>());
        Hashtable<String, String> map = new Hashtable<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
