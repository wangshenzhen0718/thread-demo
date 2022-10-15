package com.design.com.wang.singleton.type1;

public class SingleTonDemo1 {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

    }
}
class SingleTon{
    private SingleTon(){}
    private final static   SingleTon instance=new SingleTon();
    public static SingleTon getInstance(){

        return instance;
    }

}
