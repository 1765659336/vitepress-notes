package com.polymorphism.transition;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    public void eat(){
        System.out.println(this.getName()+"在吃食物");
    }
}
