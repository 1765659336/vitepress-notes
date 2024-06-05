package com.Daemon;

public class Main {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();
        Thread thread = new Thread(god);
        /* 不将god设置成守护线程，因为god永远不会执行完毕，因此虚拟机要一直等待它执行，程序一直不会终止*/
        thread.setDaemon(true);
        new Thread(you).start();
    }
}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {

        }
        System.out.println("你死了");
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while(true){

        }
    }
}
