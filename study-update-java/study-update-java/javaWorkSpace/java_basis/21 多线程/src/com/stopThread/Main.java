package com.stopThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        I i = new I();
        Thread thread = new Thread(i);
        thread.start();
        Thread.sleep(8000);
        i.stop();
    }
}

class I implements Runnable {
    private boolean lock = true;

    @Override
    public void run() {
        while(lock){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hai");
        }
    }

    public void stop(){
        this.lock = false;
    }
}