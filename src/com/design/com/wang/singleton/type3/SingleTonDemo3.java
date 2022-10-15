package com.design.com.wang.singleton.type3;

public class SingleTonDemo3 {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i1 = 0; i1 < 2000; i1++) {
            SingleTon instance1 = SingleTon.getInstance();
            System.out.println(instance1.hashCode());
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }
}
class SingleTon{
    private SingleTon(){}
    private volatile static SingleTon instance;

    public  static  SingleTon getInstance(){

        if(instance==null){
            synchronized (SingleTon.class){
                if(instance==null){
                    instance=new SingleTon();
                }
            }
        }


        return instance;
    }

}