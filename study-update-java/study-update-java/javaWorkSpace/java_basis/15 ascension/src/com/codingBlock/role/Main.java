package com.codingBlock.role;

public class Main {
    public static void main(String[] args) {
        System.out.println("哈哈哈");
    }
}

class Student {

    {
        System.out.println("不加static，在类加载的时候不会被执行，当new一个对象的时候会被调用");
    };

}
