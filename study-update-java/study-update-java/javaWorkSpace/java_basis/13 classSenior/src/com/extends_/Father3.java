package com.extends_;

public class Father3 {
    double money = 999999;
    String name;
    int age;

    public Father3(String name){
        this.name = name;
        System.out.println("父类构造器1");
    }

    public Father3(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("父类构造器2");
    }
}
