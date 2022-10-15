package com.test;

import sun.misc.Unsafe;

import java.lang.ref.SoftReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws ParseException, InterruptedException, BrokenBarrierException {

        List<String> strings = Collections.synchronizedList(new ArrayList<>());

        for (int i1 = 0; i1 < 20; i1++) {
            new Thread(()->{
                strings.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(strings);
            },String.valueOf(i1)).start();
        }

    }
}