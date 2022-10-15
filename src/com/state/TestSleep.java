package com.state;

public class TestSleep {

    public static void main(String[] args) throws InterruptedException {
        int tendown=10;
        while(true)
        {
            System.out.println(tendown--);
            Thread.sleep(1000);
            if (tendown<=0)break;
        }
    }
}
