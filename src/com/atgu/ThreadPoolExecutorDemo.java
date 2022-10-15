package com.atgu;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService threadPoolExecutor =new ThreadPoolExecutor(2,3,
                100L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
                try {
                    for (int i = 1; i <=6; i++) {
                        final   int ite=i;
                        threadPoolExecutor.execute(()->{



                            System.out.println(Thread.currentThread().getName()+"\t号窗口"+ite+"办理业务");
                            try {
                                TimeUnit.SECONDS.sleep(4);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        });
                    }



                } catch (Exception e) {
                  e.printStackTrace();
                } finally {
                    threadPoolExecutor.shutdown();
                    }




    }
}
