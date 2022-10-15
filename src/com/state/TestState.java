package com.state;

public class TestState implements Runnable{
    boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while (flag) {
            System.out.println("运行了"+i++);
        }

    }
    public  void stop()
    {
        this.flag=false;
        System.out.println("线程要停止了----");
    }

    public static void main(String[] args)  {
        TestState testState = new TestState();
        new Thread(testState).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main----"+i);
            if (i==800)
            {
                testState.stop();
            }



        }

    }
}
