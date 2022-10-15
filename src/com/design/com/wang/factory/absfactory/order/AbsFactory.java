package com.design.com.wang.factory.absfactory.order;

import com.design.com.wang.factory.absfactory.pizza.Pizza;

public interface AbsFactory {
    Pizza createPizza(String type);

}
