package com.jvm.com.wang;

public class HelloGc {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello GC");
        Thread.sleep(Integer.MAX_VALUE);
    }
}

