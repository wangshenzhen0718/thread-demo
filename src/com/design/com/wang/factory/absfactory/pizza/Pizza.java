package com.design.com.wang.factory.absfactory.pizza;

public abstract class Pizza {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void prepare();
    public void bake(){
        System.out.println(name+"  baking....");
    }

    public void cut(){
        System.out.println(name+"  cuting....");
    }

    public void box(){
        System.out.println(name+"  boxing....");
    }
}
