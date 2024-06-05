package com.extends_;

public class Son4 extends Father4{
    double age;
    public Son4(double age){
        this(age+"xx");
        System.out.println("this");
    }
    public Son4(String name){
        super(name);
        System.out.println("super");
    }
}
