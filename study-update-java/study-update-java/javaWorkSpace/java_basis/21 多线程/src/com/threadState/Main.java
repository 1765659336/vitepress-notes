package com.threadState;

public class Main implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        Thread thread = new Thread(main);
        Thread.State state = thread.getState();
        System.out.println(state); //NEW
        thread.start();
        state = thread.getState();
        System.out.println(state); //RUNNABLE
        while(state != Thread.State.TERMINATED){
            Thread.sleep(1000);
            state = thread.getState();
            System.out.println(state); //TIMED_WAITING TIMED_WAITING TIMED_WAITING TIMED_WAITING TERMINATED
        }
    }
}
