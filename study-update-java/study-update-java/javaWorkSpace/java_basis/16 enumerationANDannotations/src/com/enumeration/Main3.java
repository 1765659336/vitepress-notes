/**
 * author: Jie
 * date: 2022/3/13 13:34
 * description: 描述
 */

package com.enumeration;

public class Main3 {
    public static void main(String[] args) {

    }
}

interface CCC {
    public void say();
}

enum AAA implements CCC{
    // 使用enum定义枚举类，但是没有声明枚举时，要用;结尾
    ;
    @Override
    public void say() {
        System.out.println("你好");
    }
}
