package com.design.com.wang.prototype.deep;


import java.io.IOException;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Sheep sheep = new Sheep("tom", 1, "白色");

        DeepSheep deepSheep = new DeepSheep("tom", 1, "白色",new Sheep("tom", 1, "白色"));
        DeepSheep o = (DeepSheep) deepSheep.concreatePrototype();
        DeepSheep o1 = (DeepSheep) deepSheep.concreatePrototype();
        System.out.println(o.getFriend().hashCode());
        System.out.println(o1.getFriend().hashCode());


    }



}
