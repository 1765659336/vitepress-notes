package com.interfac.detail;

public class Main2 {
    public static void main(String[] args) {
        People people = new People();
        people.say();
        people.run();
    }
}

interface A {
    public abstract void say();
}

interface B {
    public void run();
}

class People implements A, B {

    @Override
    public void say() {
        System.out.println("hai");
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
