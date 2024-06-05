package com.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Money money = new Money();
        new Thread(money, "a").start();
        new Thread(money, "b").start();
    }
}

class Money implements Runnable {

    private double amount = 1000;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();
            if (amount > 0) {
                System.out.println(Thread.currentThread().getName() + "正在取钱");
                Thread.sleep(3000);
                amount = amount - 100;
                System.out.println(Thread.currentThread().getName() + "取出100还剩" + amount+"退出中...");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

