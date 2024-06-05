package com.interfac.Polym;

public class Main1 {
    public static void main(String[] args) {
        A a = new B();
        A a2 = new C();
        say(a);
        say(a2);
    }

    public static void say(A a){
        a.say();
    }
}

interface A{
    void say();
}
class B implements A {
    @Override
    public void say() {
        System.out.println("b");
    }
}
class C implements A {
    @Override
    public void say() {
        System.out.println("c");
    }
}
