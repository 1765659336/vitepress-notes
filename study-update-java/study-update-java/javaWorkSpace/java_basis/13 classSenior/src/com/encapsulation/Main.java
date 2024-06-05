package com.encapsulation;

public class Main {
    public static void main(String[] args) {
        Demo1 person = new Demo1("zhangsan",121,10000,"前端工程师");
        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}