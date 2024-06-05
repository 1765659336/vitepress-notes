package com.singleton;

public class Main {
    public static void main(String[] args) {
        //    1、不让调用者使用new一个对象
//    Singleton singleton = new Singleton();
//    2、提供一个方法给调用者访问对象
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton.getName());
        /*
        * 修改第一次得到的对象的成员变量，然后修改，再得到一次对象，发现两个对象的成员变量相同，证明是同一个对象*/
        singleton.setName(singleton,"zhangsan");
        singleton = Singleton.getSingleton();
        System.out.println(singleton.getName());
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton2.getName());
        System.out.println(singleton.equals(singleton2));
    }
}

class Singleton {
    public static int a;
    // 如果我们只是访问一下a,此时类会被加载，从而这个对象会被创建，但是我们并不需要这个对象
    private static Singleton singleton = new Singleton();
    public String name;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        return singleton;
    }

    public static String getName() {
        return singleton.name;
    }

    public static Singleton setName(Singleton singleton,String name) {
        singleton.name = name;
        return singleton;
    }
}
