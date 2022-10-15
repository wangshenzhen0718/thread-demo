package com.design.com.wang.factory.traditional.pizza;

public class PepperPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给制作胡椒pizza准备原材料");
    }
}
