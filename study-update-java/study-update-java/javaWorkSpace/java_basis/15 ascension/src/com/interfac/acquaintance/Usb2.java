package com.interfac.acquaintance;

public class Usb2 implements UsbInterface{

    @Override
    public void start() {
        System.out.println("u盘接入");
    }

    @Override
    public void end() {
        System.out.println("U盘弹出");
    }
}
