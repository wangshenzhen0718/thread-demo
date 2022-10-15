package com.mydemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {//ABA问题解决
    static AtomicReference<Integer> atomicReference=new AtomicReference <>(100);
    static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference <>(100,1);

    public static void main(String[] args) {
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);


        },"AAA").start();

        new Thread(()->{
            try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

            System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());


        },"BBB").start();
        try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


        System.out.println("=======================ABA问题的解决======================");

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("第一次版本号："+stamp);
            try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"第二次版本号："+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("第三次版本号："+atomicStampedReference.getStamp());

        },"CCC").start();

         new Thread(()->{
             int stamp = atomicStampedReference.getStamp();
             System.out.println(Thread.currentThread().getName()+"第一次版本号："+stamp);
             try {
                             TimeUnit.SECONDS.sleep(3);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
             boolean b = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
             System.out.println(Thread.currentThread().getName()+"\t修改成功否"+b+"当前版本"+atomicStampedReference.getStamp());
             System.out.println(Thread.currentThread().getName()+"当前实际值"+atomicStampedReference.getReference());


         },"DDD").start();

    }
}
