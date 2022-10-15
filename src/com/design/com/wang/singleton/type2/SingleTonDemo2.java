package com.design.com.wang.singleton.type2;

public class SingleTonDemo2 {
    public static void main(String[] args) {
        for (int i1 = 0; i1 < 2000; i1++) {
            new Thread(()->{
                SingleTon instance1 = SingleTon.getInstance();
                System.out.println(Thread.currentThread().getName()+":"+instance1.hashCode());

            },"A").start();
        }
        for (int i1 = 0; i1 < 2000; i1++) {
            new Thread(()->{
                SingleTon instance1 = SingleTon.getInstance();
                System.out.println(Thread.currentThread().getName()+":"+instance1.hashCode());

            },"B").start();
        }



    }


}

class SingleTon{
    private static SingleTon instance;
    private SingleTon(){}
    public static SingleTon getInstance(){
        if(instance==null){
            instance=new SingleTon();
        }
        return instance;
    }

}
