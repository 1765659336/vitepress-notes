package com.hashCode_;

public class Main {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = a;
        Object c = new Object();
        System.out.println(a.hashCode() + "-" + b.hashCode());
        System.out.println(a.hashCode()+"-" +c.hashCode());
        /* 执行结果
        142666848-142666848
        142666848-785992331*/
    }
}
