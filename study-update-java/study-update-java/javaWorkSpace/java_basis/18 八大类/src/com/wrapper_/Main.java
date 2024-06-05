/**
 * author: Jie
 * date: 2022/3/14 14:39
 * description: 描述
 */

package com.wrapper_;

public class Main {
    public static void main(String[] args) {
//        jdk5之前是手动装箱和拆箱
//        手动装箱两种方式
        int i1 = 100;
        Integer integer = new Integer(i1);
        Integer integer2 = Integer.valueOf(i1);

//        手动拆箱
        int i = integer.intValue();

//        jdk5之后，就可以自动装箱和自动拆箱
        int n2 = 200;
        Integer integer3 = n2;// 底层还是用Interger.valueOf(n2);
        int n3 = integer3;// 底层还是用的integer3.intValue();
    }
}
