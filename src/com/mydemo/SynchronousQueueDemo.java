package com.mydemo;

import java.util.concurrent.*;

public class SynchronousQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		new Thread(() -> {
		    try {       
		        System.out.println(Thread.currentThread().getName() + "\t put A ");
		        blockingQueue.put("A");
		       
		        System.out.println(Thread.currentThread().getName() + "\t put B ");
		        blockingQueue.put("B");        
		        
		        System.out.println(Thread.currentThread().getName() + "\t put C ");
		        blockingQueue.put("C");        
		        
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}, "t1").start();
		
		new Thread(() -> {
			try {
				
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				blockingQueue.take();
				System.out.println(Thread.currentThread().getName() + "\t take A ");
				
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				blockingQueue.take();
				System.out.println(Thread.currentThread().getName() + "\t take B ");
				
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				blockingQueue.take();
				System.out.println(Thread.currentThread().getName() + "\t take C ");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t2").start();
	}
	
}
