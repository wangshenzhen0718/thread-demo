package com.design.com.wang.factory.absfactory.order;

import com.design.com.wang.factory.absfactory.pizza.BJGreekPizza;
import com.design.com.wang.factory.absfactory.pizza.BJPepperPizza;
import com.design.com.wang.factory.absfactory.pizza.Pizza;

public class BJFactory implements AbsFactory{
    Pizza pizza=null;
    @Override
    public Pizza createPizza(String type) {
        if(type.equals("greek")){
            pizza=new BJGreekPizza();
        }else if (type.equals("pepper")){
            pizza=new BJPepperPizza();
        }else {
            pizza=null;
        }
        return pizza;
    }
}
