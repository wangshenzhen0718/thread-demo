package com.design.com.wang.factory.absfactory.pizza;

public class LDGreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给制作伦敦希腊pizza准备原材料");
    }
}
