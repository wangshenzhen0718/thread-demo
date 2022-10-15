package com.design.com.wang.prototype.deep;

import com.design.com.wang.prototype.deep.Sheep;

import java.io.*;

public class DeepSheep implements Cloneable, Serializable {
    private String name;
    private int age;
    private String color;
    private Sheep friend;

    public DeepSheep(String name, int age, String color, Sheep friend) {
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
public Object concreatePrototype() throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bio = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bio);
    oos.writeObject(this);
    ByteArrayInputStream bis = new ByteArrayInputStream(bio.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);
    DeepSheep o = (DeepSheep) ois.readObject();

    return o;
}
    @Override
    public String toString() {
        return "DeepSheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", friend=" + friend +
                '}';
    }
}
