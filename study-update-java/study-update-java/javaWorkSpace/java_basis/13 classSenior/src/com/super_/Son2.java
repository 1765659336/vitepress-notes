package com.super_;

public class Son2 extends Father2{
    public Son2(){
        /*父亲和爷爷都有salary，但是拿到的值是父亲的
        * 父亲没有hobby，但是可以拿到爷爷的*/
        System.out.println(super.salary);
        System.out.println(super.hobby);
    }
}
