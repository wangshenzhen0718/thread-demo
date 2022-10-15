package com.design.com.wang.factory.traditional.order;

import com.design.com.wang.factory.traditional.pizza.CheesePizza;
import com.design.com.wang.factory.traditional.pizza.GreekPizza;
import com.design.com.wang.factory.traditional.pizza.PepperPizza;
import com.design.com.wang.factory.traditional.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    public OrderPizza() throws IOException {

        Pizza pizza=null;
        do{
            String type = getType();
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
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();


        }while (true);
    }


    public String getType() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入披萨种类：");
        String s = bufferedReader.readLine();
        return s;
    }
}
