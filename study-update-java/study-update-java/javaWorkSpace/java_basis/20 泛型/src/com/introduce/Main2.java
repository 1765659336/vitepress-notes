package com.introduce;

public class Main2 {
    public static void main(String[] args) {
        Job<A> aJob = new Job<>();
        // 约定的泛型是A,但是B继承了A,是A的子类
        aJob.say(new B("hhh"));
    }
}

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }
}

class B extends A {

    public B(String name) {
        super(name);
    }
}

class Job<T>{
    public void say(T a){
        System.out.println(a);
    }
}
