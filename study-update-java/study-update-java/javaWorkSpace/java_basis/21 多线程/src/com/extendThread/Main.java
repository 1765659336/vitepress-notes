package com.extendThread;

public class Main extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.println("run");
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("main");
        }
    }
}
