package com.threadPriority;

public class Main implements Runnable{
    public static void main(String[] args) {
        Main main = new Main();
        Thread thread = new Thread(main);
        System.out.println(thread.getPriority());
        thread.setPriority(10);
        System.out.println(thread.getPriority());
    }

    @Override
    public void run() {

    }
}
