package com.threadYield;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThread2 myThread2 = new MyThread2();
        Threaded threaded= new Threaded();
        for (int i = 0; i < 64; i++) {
            new Thread(threaded,((Integer)i).toString()).start();
        }
        new Thread(myThread2,"b").start();
        Thread.sleep(1000);
        new Thread(myThread, "a").start();

    }
}

class MyThread implements Runnable {
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始执行");
        System.out.println(Thread.currentThread().getName()+"停止执行");
    }
}
class Threaded implements Runnable {
    @Override
    public void run() {
        System.out.println("线程被占据");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程释放");
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("开始礼让");
        for (int i = 0; i < 1000000; i++) {
                Thread.yield();
        }
        System.out.println("停止礼让");
    }
}