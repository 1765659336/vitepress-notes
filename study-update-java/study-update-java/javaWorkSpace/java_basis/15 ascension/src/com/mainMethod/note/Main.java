package com.mainMethod.note;

public class Main {
    /**
     * @a 类变量
     * @b 成员变量
     * @say 类方法
     * @say2 成员方法
     */
    public static int a;

    public static void say() {
        System.out.println("hi");
    }

    public int b;

    public void say2() {
        System.out.println("hi");
    }

    public static void main(String[] args) {
        //        在main方法中成员变量和方法要通过new一个对象来访问
        Main main = new Main();
        System.out.println(main.b);
        //        类方法和类变量直接访问
        main.say2();
        System.out.println(a);
        say();
    }
}
