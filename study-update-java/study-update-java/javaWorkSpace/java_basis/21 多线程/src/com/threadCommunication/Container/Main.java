package com.threadCommunication.Container;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        Consumers consumers = new Consumers(container);
        Producer producer = new Producer(container);
        new Thread(consumers).start();
        new Thread(producer).start();
    }
}

class Container {
    private String[] arr = new String[10];
    private int currentNumber = 0;

    public synchronized void push() {
        if (currentNumber == 9) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arr[currentNumber++] = "鸡";
        //            通知消费者消费鸡
        this.notifyAll();
    }

    public synchronized void pop(){
        while (currentNumber == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arr[currentNumber--] = "";
        //            通知消费者消费鸡
        this.notifyAll();
    }
}

class Producer implements Runnable {
    private Container container;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push();
            System.out.println("添加了第" + i + "只鸡");
        }
    }
}

class Consumers implements Runnable {
    private Container container;

    public Consumers(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.pop();
            System.out.println("消费了第" + i + "只鸡");
        }
    }
}