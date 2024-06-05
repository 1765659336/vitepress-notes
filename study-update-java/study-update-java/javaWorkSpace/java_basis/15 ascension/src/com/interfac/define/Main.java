package com.interfac.define;

public class Main {
    public static void main(String[] args) {

    }
}

interface CCC{
    // 可以有自己的变量
    public int a = 0;

    // 可以有自己的静态方法
    public static void say(){
        System.out.println("hai");
    }

    // 可以有自己的成员方法，带方法体,必须要用default来修饰
    public default void start(){
        System.out.println("开始");
    }
}