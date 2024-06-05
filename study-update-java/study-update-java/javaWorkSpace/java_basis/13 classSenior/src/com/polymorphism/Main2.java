package com.polymorphism;

public class Main2 {
    public static void main(String[] args) {
        Master2 master = new Master2("zhangsan");
        Animal dog = new Dog("小黄");
        Animal cat = new Cat("小花");
        Food bone = new Bone("猪骨头");
        Food fish = new Fish("草鱼");
        master.feed(cat,fish);
        master.feed(dog,bone);
    }
}
