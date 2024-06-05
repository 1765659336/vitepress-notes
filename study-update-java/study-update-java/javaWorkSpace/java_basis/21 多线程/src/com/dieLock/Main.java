package com.dieLock;

public class Main {
    public static void main(String[] args) {
        Tradesman tradesman = new Tradesman();
        Buyer buyer = new Buyer();
        new Thread(tradesman).start();
        new Thread(buyer).start();
    }
}

// 商人
class Tradesman implements Runnable{

    public static String goods = "商品";

    @Override
    public void run() {
        synchronized (goods){
            System.out.println("货在我手上，把你的钱给我，我再给货给你");
            try {
//                等另外一个线程拿到资源
                Thread.sleep(2000);
                synchronized (Buyer.money){
                    System.out.println("交易成功");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 钱
class Buyer implements Runnable{

    public static String money = "100万";

    @Override
    public void run() {
        synchronized (money){
            System.out.println("钱在我手上，把你的货给我，我再给钱给你");
            try {
//                等另外一个线程拿到资源
                Thread.sleep(2000);
                synchronized (Tradesman.goods){
                    System.out.println("交易成功");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
