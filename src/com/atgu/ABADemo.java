package com.atgu;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {

   static AtomicReference<Integer> atomicReference=new AtomicReference<Integer>(100);
   static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<Integer>(100,1);


    public static void main(String[] args) {
        //new ArrayList<>().add(1);
        new Thread(
                ()->{
                    atomicReference.compareAndSet(100,2019);
                    atomicReference.compareAndSet(2019,100);
                }


       ,"t1" ).start();

        new Thread(

                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get().toString());

                }


                ,"t2" ).start();

    }
}
