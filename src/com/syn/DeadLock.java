package com.syn;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {


    public static void main(String[] args) {
        Makeup hh = new Makeup(0, "灰姑娘");
        Makeup bb = new Makeup(1, "白雪姑娘");
        hh.start();
        bb.start();

    }
}

//口红
class Lipstick { }
//镜子
class Mirror { }
class Makeup extends Thread {
    //需要的资源只有一份,用static保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choice;//选择
    String girlName;//使用化妆品的人

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {//获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror) {//一秒钟后想获得镜子
                    System.out.println(this.girlName + "获得镜子的锁");
                }
            }

        } else {

            synchronized (mirror) {//获得口红镜子
                System.out.println(this.girlName + "获得镜子的锁");
                Thread.sleep(2000);
                synchronized (lipstick) {//二秒钟后想获得的锁
                    System.out.println(this.girlName + "获得口红的锁");
                }
            }

        }
    }
}