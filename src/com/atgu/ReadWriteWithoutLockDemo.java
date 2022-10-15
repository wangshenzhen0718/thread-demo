package com.atgu;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteWithoutLockDemo {


    public static void main(String[] args) {

        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int itemp=i;
            new Thread(()->{
                try {
                    myCache.put(itemp+"",itemp+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

           ,String.valueOf(i) ).start();
        }
        // 线程操作资源类， 5个线程读
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    myCache.get(tempInt + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }


    }
}
class  MyCache{
    private volatile   HashMap<String,Object> map=new HashMap<>();
    private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public void put(String key,Object value) throws InterruptedException {
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            TimeUnit.MILLISECONDS.sleep(200);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();

        }


    }
    public void get(String key) throws InterruptedException {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取...." );
            TimeUnit.MILLISECONDS.sleep(200);
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成"+value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }


    }
}