package com.abst;

public class define {

}

abstract class Animal {
    public abstract void eat();
}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
