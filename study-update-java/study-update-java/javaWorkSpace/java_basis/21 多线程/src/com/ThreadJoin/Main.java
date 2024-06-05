package com.ThreadJoin;

public class Main implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        Thread thread = new Thread(main);
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程");
            thread.join();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("插队线程");
        }
    }
}
