package com.hxl;

import java.util.LinkedList;

/**
 * Created by hxl on 2016/9/29.
 */
public class Thread {

    public static void main(String[] args) {
        new java.lang.Thread(() -> {
            Queue<String> queue = Queue.getInstance();
            while (true) {
                System.out.println(queue.pop());
            }
        }).start();
        new java.lang.Thread(() -> {

            Queue<String> queue = Queue.getInstance();
            int i = 0;
            while (true) {
                i++;
                queue.push(i +"");
                try {
                    java.lang.Thread.sleep(1l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

 class Queue<T> {
    private static Queue instance = new Queue();
     private LinkedList<T> list = new LinkedList<>();

    private Queue() {

    }

    public static <T>Queue<T> getInstance() {
        return instance;
    }

     public void push(T t) {
         synchronized (list) {
             list.addLast(t);
             list.notifyAll();
         }
     }

     public T pop() {
         synchronized (list) {
             while (list.isEmpty()) {
                 try {
                     list.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             return list.removeFirst();
         }
     }

}