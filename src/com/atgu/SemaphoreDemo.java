package com.atgu;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);


        for (int i = 100; i > 0; i--) {
            final int i1=i;
            new Thread(
                    ()->{
                        try {
                            semaphore.acquire();
                            Thread.sleep(3000);
                            System.out.println(Thread.currentThread().getName()+"获得车位");

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            semaphore.release();
                            System.out.println(Thread.currentThread().getName()+"释放车位");

                        }

                    },String.valueOf(i1)
            ).start();
        }
    }
}
