package com.design.com.wang.factory.improve.order;

import javax.print.attribute.standard.OrientationRequested;
import java.io.IOException;

public class PizzaStore {
    public static void main(String[] args) throws IOException {
        new OrderPizza(new SimpleFactory());
    }
}
