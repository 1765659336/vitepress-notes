package com.interfac.acquaintance;

public class Usb1 implements UsbInterface{
    @Override
    public void start() {
        System.out.println("手机接入");
    }
    @Override
    public void end() {
        System.out.println("手机弹出");
    }
}
