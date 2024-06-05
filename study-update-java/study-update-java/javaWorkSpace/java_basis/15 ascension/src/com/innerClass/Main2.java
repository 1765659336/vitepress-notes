package com.innerClass;

public class Main2 {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.way();
    }
}

class Outer2 {
    public void way() {
        /* jvm匿名内部类实际上在解析的时候，底层给了匿名内部类一个名字一般是外部类名加$1 */
        I i = new I() {
            @Override
            public void say() {
                System.out.println("hi");
            }
        };
        /*
            hi
            class com.innerClass.Outer2$1
        */
        i.say();
        System.out.println(i.getClass());
        // 匿名内部类没有名字，没法给程序员调用，所以只能”使用一次“就不能再使用了
    }
}

interface I {
    public void say();
}