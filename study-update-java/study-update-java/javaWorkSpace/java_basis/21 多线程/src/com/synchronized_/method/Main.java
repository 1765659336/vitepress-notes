package com.synchronized_.method;

public class Main {
    public static void main(String[] args) {
//        new 一个ATM机
        Money money = new Money();
//        一次性创建15个人去取钱
        for (int i = 0; i < 15; i++) {
            new Thread(money, ((Integer) i).toString()).start();
        }
    }
}

class Money implements Runnable {

    private double money = 1000;

    @Override
    public synchronized void run() {
        try {
//                模拟用户操作ATM机的时间
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (money > 0) {
            money = money - 100;
            System.out.println(Thread.currentThread().getName() + "取出100块还剩" + money);
        } else {
            System.out.println(Thread.currentThread().getName() + "没有取到钱，因为没钱了。");
        }
    }
}
