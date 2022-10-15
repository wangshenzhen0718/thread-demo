package com.syn;

public class ProductorAndConsumer {
    public static void main(String[] args) {
        SyncContainer syncContainer = new SyncContainer();
        new sheng(syncContainer).start();
        new Consum(syncContainer).start();

    }
}

class sheng extends Thread{
    SyncContainer container;

    public sheng(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                container.push(new Productor(i));
                System.out.println("生产了" + i + "件产品");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consum extends Thread{
    SyncContainer container;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("消费了"+container.pop().id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Consum(SyncContainer container){
    this.container=container;


}



}
class Productor{
    int id;

    public Productor(int id) {
        this.id = id;
    }
}
class SyncContainer{
    Productor[] productors=new Productor[10];
    int count=0;
    public synchronized void push(Productor productor) throws InterruptedException {
        while(count==productors.length)
        {
            this.wait();
        }
        productors[count]=productor;
        count++;
        this.notifyAll();

    }
    public synchronized Productor pop() throws InterruptedException {
        while (count<=0)
        {
            this.wait();
        }
        count--;
        Productor productor=productors[count];
        this.notifyAll();
        return productor;
    }



}