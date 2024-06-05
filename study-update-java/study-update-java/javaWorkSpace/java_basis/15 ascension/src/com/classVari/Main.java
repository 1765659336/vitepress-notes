package com.classVari;

public class Main {
    /* 现在有一个需求，就是一群小孩子在玩游戏，一会又有小朋友会陆陆续续的加入，
    请问我怎么知道当前有多少小朋友在玩游戏 使用oop的话*/
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("小红");
        student.count++;

        Student student2 = new Student();
        student.setName("小红2");
        student2.count++;

        Student student3 = new Student();
        student.setName("小红3");
        student3.count++;
        System.out.println(student.count); // 3
    }
}

class Student {
    private String name;
    // 类变量
    public static int count = 0;
    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}