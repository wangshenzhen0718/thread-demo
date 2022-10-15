package com.design.com.wang.factory.absfactory.order;

import java.io.IOException;

public class PizzaStore {
    public static void main(String[] args) throws IOException {
        new OrderPizza(new BJFactory());

    }
}
