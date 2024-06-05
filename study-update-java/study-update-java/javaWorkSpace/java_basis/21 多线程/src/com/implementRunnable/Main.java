package com.implementRunnable;

public class Main {
    public static void main(String[] args) {
        IRunnable iRunnable = new IRunnable();
        Thread thread = new Thread(iRunnable);
        thread.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("main");
        }
    }
}

class IRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("irunnable");
        }
    }
}
