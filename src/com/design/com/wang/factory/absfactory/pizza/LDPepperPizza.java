package com.design.com.wang.factory.absfactory.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给制作伦敦胡椒pizza准备原材料");
    }
}
