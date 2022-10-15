package com.design.com.wang.factory.traditional.pizza;

public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给制作希腊pizza准备原材料");
    }
}
