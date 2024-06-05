package com.polymorphism;

public class Master {
    private String name;

    public Master(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*喂狗食物*/
    public void feed(Dog dog, Bone bone){
        System.out.println(this.name + "给" + dog.getName()+"喂"+bone.getName());
    }

    /*方法重载喂猫食物*/
    public void feed(Cat cat, Fish fish){
        System.out.println(this.name + "给" + cat.getName()+"喂"+fish.getName());
    }

    /*不使用多态，导致代码的可复用性低，代码维护起来困难*/
}
