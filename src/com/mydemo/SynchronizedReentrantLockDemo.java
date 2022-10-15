package com.mydemo;

public class SynchronizedReentrantLockDemo {//java锁之可重入锁和递归锁代码验证 Synchronized可入锁演示程序

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSMS();

        },"t1").start();
        new Thread(()->{
            phone.sendSMS();

        },"t2").start();
    }
}
class Phone{
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+"\t invoke sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\t invoke sendEmail()");

    }
}
