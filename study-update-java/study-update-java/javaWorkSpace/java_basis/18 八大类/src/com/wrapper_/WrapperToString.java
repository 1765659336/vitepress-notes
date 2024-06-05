/**
 * author: Jie
 * date: 2022/3/14 15:31
 * description: 描述
 */

package com.wrapper_;

public class WrapperToString {
    public static void main(String[] args) {
        // 包装类（Integer为例）转String
        Integer n = 1;
            // 方式1
        String sn1 = n + "";
            // 方式2
        String sn2 = n.toString();
            // 方式3
        String sn3 = String.valueOf(n);

        // String 转包装类
        String str = "1";
            // 方式1
        Integer is1 = Integer.parseInt(str);
            // 方式2
        Integer is2 = new Integer(str); // 接收字符参数的构造器
        System.out.println(sn1 instanceof String); //true
        System.out.println(sn2 instanceof String); //true
        System.out.println(sn3 instanceof String); //true
        System.out.println(is1 instanceof Integer); //true
        System.out.println(is1 instanceof Integer); //true
    }
}
