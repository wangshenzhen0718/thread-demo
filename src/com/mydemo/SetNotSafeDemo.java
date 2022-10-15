package com.mydemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetNotSafeDemo {
    public static void main(String[] args) {
        //HashSet<String> set = new HashSet<>();
        //CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
