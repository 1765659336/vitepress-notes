package com.publicMethod;

public class Main {
    public static void main(String[] args) {
        Student.say();
        Student.content = "您好";
        Student.sayAll();
    }
}

class Student {
    public static String content = "你好";
    public static void say(){
        System.out.println(Student.content);
    }

    public  static void sayAll(){
        Student.say();
        System.out.println("我都要说");
    }
}