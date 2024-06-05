package com.polymorphism;

public class Main3 {
    public static void main(String[] args) {
        Father father = new Son();
        System.out.println(father.count);
        Son son = (Son) father;
        System.out.println(son.count);
        /*属性的值由编译类型决定*/
    }
}

class Father {
    int count = 10;
}

class Son extends Father{
    int count = 20;
}
