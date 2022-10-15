package com.atgu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        System.out.println(queue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(queue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(queue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(queue.offer("a",2, TimeUnit.SECONDS));
        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2-o1;
            }
        });
        integers.add(-1);
        integers.add(-4);
        integers.add(2);
        integers.add(0);
        integers.add(6);
        integers.add(3);
        System.out.println(integers);

    }
}
