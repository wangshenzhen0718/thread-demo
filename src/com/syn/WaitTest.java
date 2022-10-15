package com.syn;

/**
 * @author shangjing
 * @date 2018/11/22 3:26 PM
 * @describe wait,notify实现
 */
public class WaitTest {

    private static int count = 0;

    private static final int buffCount = 10;

    private static String lock = "lock";


    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == buffCount) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "-生产者生产，数量为:" + count);
                    lock.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock) {
                    while (count == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "-消费者消费，数量为："+ count);
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();
        new Thread(waitTest.new Producer()).start();
        new Thread(waitTest.new Consumer()).start();
        new Thread(waitTest.new Producer()).start();
        new Thread(waitTest.new Consumer()).start();
        new Thread(waitTest.new Producer()).start();
        new Thread(waitTest.new Consumer()).start();

    }

}
