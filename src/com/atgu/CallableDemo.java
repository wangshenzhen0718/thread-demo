package com.atgu;

import java.util.concurrent.*;

class MyCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("进入了call()方法。。。。");
        return 1024;
    }
}
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());

        new Thread(futureTask,"aaa").start();
        new Thread(futureTask,"bbb").start();
        while (!futureTask.isDone())
        {

        }
        int result1=100;
        System.out.println(futureTask.get()+result1);//获得返回值

    }
}
