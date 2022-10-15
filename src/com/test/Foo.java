package com.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;


class  Share{
    private int n;


    public Share(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void printFoo(){
        System.out.println("打印foo");

    }
    public void printBar(){
        System.out.println("打印bar。。");

    }


}
public class Foo {
    private static volatile boolean flag=true;

    public static void main(String[] args) {
        Share share = new Share(5);
        int n = share.getN();
        LinkedBlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);
        LinkedBlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);

        new Thread(()->{
            for (int i1 = 0; i1 < n; i1++) {
                while (!flag);
                share.printFoo();
                flag=false;
            }
        },"A").start();
        new Thread(()->{

            for (int i1 = 0; i1 < n; i1++) {
                while (flag);
                share.printBar();
                flag=true;


            }
        },"B").start();


    }





}
