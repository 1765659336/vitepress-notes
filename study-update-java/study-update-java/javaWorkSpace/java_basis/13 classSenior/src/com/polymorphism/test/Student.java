package com.polymorphism.test;

public class Student extends People{
    public double age;

    public double getAge() {
        return age;
    }

    public Student(double age) {
        setAge(age);
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void speak(){
        System.out.println("我是学生");
    }
}
