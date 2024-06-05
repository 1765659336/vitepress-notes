package com.classVari;

public class Main2 {
    public static void main(String[] args) {
//        可以直接访问到
        System.out.println(Dog.count); //0
    }
}

class Dog {
    public static int count = 0;
    public Dog() {
    }
}
