package com.codingBlock.details;

public class Main {
    public static void main(String[] args) {
        System.out.println(Son.a);
        Son son = new Son();
    }
}

class Father {
    static {
        System.out.println("静态代码块");
    }
}

class Son extends Father {
    public static int a;
    static {
        System.out.println("静态代码块");
    }
}

