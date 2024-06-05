package com.extends_;

public class Son3 extends Father3{
    public Son3(String name){
        super(name);
    }
    public Son3(String name,int age){
        super(name,age);
        this.name = name;
        this.age = age;
    }
}
