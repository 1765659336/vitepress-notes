package com.toString_;

public class Main {
    public static void main(String[] args) {
        /*Object的toString方法源码
        * public String toString() {
        *   // 类名 + @ + 将对象的hashCode值转成16进制字符串
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
         * */
        Object o = new Object();
        System.out.println(o.toString()); // java.lang.Object@880ec60
    }
}
