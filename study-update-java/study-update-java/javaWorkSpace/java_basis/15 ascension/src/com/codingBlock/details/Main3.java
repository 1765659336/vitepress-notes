package com.codingBlock.details;

public class Main3 {
    public static void main(String[] args) {
        Cat cat = new Cat();
    }
}

class Animal{
    //    静态变量初始化
    public static int a = A();

    private static int A() {
        System.out.println("父静态变量初始化");
        return 1;
    }

    //    普通代码块
    {
        System.out.println("父普通代码块");
    }

    //    属性初始化
    public int b = B();

    private int B() {
        System.out.println("父属性初始化");
        return 1;
    }

    //    静态代码块
    static {
        System.out.println("父静态代码块");
    }


    //    构造器
    public Animal() {
        // 隐式调用了super()和普通代码块，因此普通代码块的逻辑执行先与构造器中的逻辑
        System.out.println("父构造器");
    }
}

class Cat extends Animal{
    //    静态变量初始化
    public static int a = A();

    private static int A() {
        System.out.println("子静态变量初始化");
        return 1;
    }

    //    普通代码块
    {
        System.out.println("子普通代码块");
    }

    //    属性初始化
    public int b = B();

    private int B() {
        System.out.println("子属性初始化");
        return 1;
    }

    //    静态代码块
    static {
        System.out.println("子静态代码块");
    }

    //    构造器
    public Cat() {
        // 隐式调用了super()和普通代码块，因此普通代码块的逻辑执行先与构造器中的逻辑
        System.out.println("子构造器");
    }
}