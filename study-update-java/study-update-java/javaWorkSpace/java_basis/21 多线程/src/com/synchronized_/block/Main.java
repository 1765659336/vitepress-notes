package com.synchronized_.block;

public class Main {
    public static void main(String[] args) {
//        new 一个ATM机
        ATM atm = new ATM();
//        一次性创建15个人去取钱
        for (int i = 0; i < 15; i++) {
            new Thread(atm, ((Integer) i).toString()).start();
        }
    }
}

class ATM implements Runnable {

    private Money money = new Money(1000);

    @Override
    public void run() {
        synchronized (money){
            try {
//                模拟用户操作ATM机的时间
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (money.getAmount() > 0) {
                money.setAmount(money.getAmount() - 100);
                System.out.println(Thread.currentThread().getName() + "取出100块还剩" + money.getAmount());
            } else {
                System.out.println(Thread.currentThread().getName() + "没有取到钱，因为没钱了。");
            }
        }
    }

    class Money{
        private double amount;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public Money(double amount) {
            setAmount(amount);
        }
    }
}