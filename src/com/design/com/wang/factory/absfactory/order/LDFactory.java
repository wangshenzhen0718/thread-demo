package com.design.com.wang.factory.absfactory.order;

import com.design.com.wang.factory.absfactory.pizza.*;

public class LDFactory implements AbsFactory{
    Pizza pizza=null;
    @Override
    public Pizza createPizza(String type) {
        if(type.equals("greek")){
            pizza=new LDGreekPizza();
        }else if (type.equals("pepper")){
            pizza=new LDPepperPizza();
        }else{
            pizza=null;
        }
        return pizza;
    }
}
