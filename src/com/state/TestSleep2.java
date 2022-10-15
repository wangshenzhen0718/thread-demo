package com.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date(System.currentTimeMillis());
        while(true)
        {
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("yyyy年MM月dd日：HH时mm分ss秒").format(date));
             date = new Date(System.currentTimeMillis());


        }
    }
}
