package com.design.com.wang.prototype.shallow;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("tom", 1, "白色");
        Sheep clone1 = (Sheep) sheep.clone();
        Sheep clone2 = (Sheep) sheep.clone();
        Sheep clone3 = (Sheep) sheep.clone();
        Sheep clone4 = (Sheep) sheep.clone();
        System.out.println(clone1);
        System.out.println(clone2);
        System.out.println(clone3);
        System.out.println(clone4);
        System.out.println(clone1==clone2);
        QianSheep qianSheep = new QianSheep("tom", 1, "白色",new Sheep("tom", 1, "白色"));
        QianSheep c1 = (QianSheep) qianSheep.clone();
        QianSheep c2 = (QianSheep) qianSheep.clone();
        System.out.println(c1==c2);
        System.out.println(c1.getFriend()==c2.getFriend());


    }



}
