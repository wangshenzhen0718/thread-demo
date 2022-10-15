package com.design.com.wang.factory.improve.order;

import com.design.com.wang.factory.traditional.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    SimpleFactory simpleFactory;
    Pizza pizza=null;

    public OrderPizza(SimpleFactory simpleFactory) throws IOException {
        String type="";
        do{
            type=getType();
            pizza = simpleFactory.createPizza(type);
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

