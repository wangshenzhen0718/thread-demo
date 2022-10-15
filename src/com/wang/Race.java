package com.wang;

public class Race implements Runnable{
    public  String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子")&&i%10==0)
            {
                try {
                    Thread.sleep(2);
                    //System.out.println(Thread.currentThread().getName()+"在睡觉");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            boolean flag;
            if(isWinner(i))break;
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");


        }

    }

    public static void main(String[] args) {
        new Thread(new Race(),"兔子").start();
        new Thread(new Race(),"乌龟").start();
    }
    public boolean isWinner(int i)
    {
        if(winner!=null)return true;
        else
        {
            if (i>=100)
            {
                winner=Thread.currentThread().getName();
                System.out.println("胜利者是"+winner);
                return true;
            }
        }
        return false;

    }



}
