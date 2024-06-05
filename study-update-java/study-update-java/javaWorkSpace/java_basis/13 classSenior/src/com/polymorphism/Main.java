package com.polymorphism;

public class Main {
    public static void main(String[] args) {
        Master master = new Master("zhangsan");
        Dog dog = new Dog("小黄");
        Cat cat = new Cat("小花");
        Bone bone = new Bone("猪骨头");
        Fish fish = new Fish("草鱼");
        master.feed(cat,fish);
        master.feed(dog,bone);
    }
}
