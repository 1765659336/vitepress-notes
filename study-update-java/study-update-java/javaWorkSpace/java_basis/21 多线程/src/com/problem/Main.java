package com.problem;

public class Main {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"我").start();
        new Thread(ticket,"其它人").start();
        new Thread(ticket,"可恶的黄牛党").start();
    }
}

class Ticket implements Runnable{
    private int ticketNumber = 10;
    @Override
    public void run() {
        while(true){
            if(ticketNumber<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"买了第"+ticketNumber--+"张票");
        }
    }
}
