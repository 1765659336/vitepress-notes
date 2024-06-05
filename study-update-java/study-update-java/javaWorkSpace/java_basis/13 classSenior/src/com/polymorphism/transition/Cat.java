package com.polymorphism.transition;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    public void eat(){
        System.out.println(this.getName()+"在吃食物");
    }
}
