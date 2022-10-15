package com.design.com.wang.factory.absfactory.order;

import com.design.com.wang.factory.absfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    AbsFactory absFactory;
    Pizza pizza=null;
    String type="";

    public OrderPizza(AbsFactory absFactory) throws IOException {
        do{
            type=getType();
            pizza = absFactory.createPizza(type);
            if(pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购失败");
                break;
            }
        }while (true);

    }

    public String getType() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入披萨种类：");
        String s = bufferedReader.readLine();
        return s;
    }
}
