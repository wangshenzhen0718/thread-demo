package com.design.com.wang.factory.improve.order;

import com.design.com.wang.factory.traditional.pizza.CheesePizza;
import com.design.com.wang.factory.traditional.pizza.GreekPizza;
import com.design.com.wang.factory.traditional.pizza.PepperPizza;
import com.design.com.wang.factory.traditional.pizza.Pizza;

public class SimpleFactory {

    public Pizza createPizza(String type){
        Pizza pizza=null;
        if(type.equals("greek")){
            pizza=new GreekPizza();
            pizza.setName("希腊披萨");
        }else if (type.equals("cheese")){
            pizza=new CheesePizza();
            pizza.setName("奶酪披萨");

        }else if (type.equals("pepper")){
            pizza=new PepperPizza();
            pizza.setName("胡椒披萨");

        }else{
            pizza=null;
        }
        return pizza;

    }
}
