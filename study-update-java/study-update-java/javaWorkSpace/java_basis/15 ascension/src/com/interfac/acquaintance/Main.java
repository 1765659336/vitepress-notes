package com.interfac.acquaintance;

public class Main {
    public static void main(String[] args) {
        Usb1 usb1 = new Usb1();
        Usb2 usb2 = new Usb2();
        Computer.work(usb1);
        Computer.work(usb2);
    }
}
