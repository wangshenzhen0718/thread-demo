package com.wang;

public class ThreadProxy implements Runnable{
    @Override
    public void run() {
        System.out.println("ssss");

    }

    public static void main(String[] args) {
        new Thread(new ThreadProxy()).start();
    }
}
