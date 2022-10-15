package com.mydemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();
        new Thread(phone2,"t1").start();
        new Thread(phone2,"t2").start();

    }
}
class Phone2 implements Runnable{
    Lock lock=new ReentrantLock();
    public void getLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get Lock");
            setLock();
        } finally {
            lock.unlock();
        }
    }
    public void setLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set Lock");
        } finally {
            lock.unlock();
        }
    }





    @Override
    public void run() {
        getLock();

    }
}