package com.atgu;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData2 {
    volatile int number = 0;
    AtomicInteger  atomicInteger=new AtomicInteger();
    public void addPlusPlus() {
        number ++;
    }

    public void addPlusPlus2() {
        atomicInteger.getAndIncrement();
    }


}
 class VolatileAtomicityDemo{
     public static void main(String[] args) {
         MyData2 myData2 = new MyData2();

         for (int i = 0; i < 20; i++) {
             new Thread(
                     ()->{
                         for (int i1 = 0; i1 < 10000; i1++) {
                             myData2.addPlusPlus();
                             myData2.addPlusPlus2();


                         }


                     }
             ,String.valueOf(i)).start();
         }

         while (Thread.activeCount()>2)
         {
             Thread.yield();
         }
         System.out.println(myData2.number);
         System.out.println(myData2.atomicInteger);
     }

}