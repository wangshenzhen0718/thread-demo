package com.mydemo;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteWithoutLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int i1=i;
            new Thread(()->{
                myCache.put(i1+"",i1+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int i1=i;
            new Thread(()->{
                myCache.get(i1+"");
            },String.valueOf(i)).start();
        }

    }
}


class MyCache{
    private  volatile HashMap<String,String> map=new HashMap<>();
    ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    public void put(String key,String value){
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
        try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"\t 写入完毕"+key);
        readWriteLock.writeLock().unlock();


    }
    public void get(String key){
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"\t正在读取：");
        try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        String s = map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t读取完"+s);
        readWriteLock.readLock().unlock();

    }


}