package com.design.com.wang.prototype.shallow;

public class QianSheep implements Cloneable{
    private String name;
    private int age;
    private String color;
    private Sheep friend;

    public QianSheep(String name, int age, String color, Sheep friend) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public Sheep getFriend() {
        return friend;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (QianSheep)super.clone();
    }
}
