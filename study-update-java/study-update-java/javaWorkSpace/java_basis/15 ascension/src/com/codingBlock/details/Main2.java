package com.codingBlock.details;

public class Main2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}

class Dog {
    //    静态变量初始化
    public static int a = A();

    private static int A() {
        System.out.println("静态变量初始化");
        return 1;
    }

    //    普通代码块
    {
        System.out.println("普通代码块");
    }

    //    属性初始化
    public int b = B();

    private int B() {
        System.out.println("属性初始化");
        return 1;
    }

    //    静态代码块
    static {
        System.out.println("静态代码块");
    }


    //    构造器
    public Dog() {
        // 隐式调用了super()和普通代码块，因此普通代码块的逻辑执行先与构造器中的逻辑
        System.out.println("构造器");
    }
}
