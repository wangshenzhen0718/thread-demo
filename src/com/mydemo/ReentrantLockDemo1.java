package com.mydemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {

    public static void main(String[] args) {
        Phone1 phone1=new Phone1();
        new Thread(phone1, "t1").start();
        new Thread(phone1, "t2").start();

    }
}


class Phone1 implements Runnable{
    Lock lock=new ReentrantLock();
   public void getLock(){
      lock.lock();
      try {
          System.out.println(Thread.currentThread().getName()+"\t getLock");
          setLock();

      }  finally {
        lock.unlock();
      }


   }
    public void setLock(){
       lock.lock();
       try {
           System.out.println(Thread.currentThread().getName()+"\t setLock");


       }finally {
         lock.unlock();
       }

    }
    @Override
    public void run() {
       getLock();


    }
}