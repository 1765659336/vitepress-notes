/**
 * author: Jie
 * date: 2022/3/14 10:29
 * description: 描述
 */

package com.fiveRunException;

public class Main {
    public static void main(String[] args) {
        // one();
        // two();
        // three();
        // four();
        five();
    }


    public static void one(){
        // 1、 NullPointerException 空指针异常，要访问的对象为null时
        String a = null;
        System.out.println(a.length());
    }

    public static void two(){
        // 2、 ArithmeticException 数学运算异常
        int num = 2;
        int num2 = 0;
        System.out.println(num / num2);
    }

    public static void three(){
        // 3、ArrayIndexOutOfBoundsException数组下标越界异常
        int[] arr = {1,2,3};
        for (int i = 0; i < arr.length+1; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void four(){
        // 4、ClassCastException 类型转换异常
        A a = new B();
        C c = (C) a;
    }

    public static void five(){
        // 5、NumberFormatException 数字格式不正确异常
        String str = "123";
        System.out.println(Integer.parseInt(str));
        String str2 = "abc";
        System.out.println(Integer.parseInt(str2));
    }
}

class A {

}

class B extends A{

}

class C extends A{

}
