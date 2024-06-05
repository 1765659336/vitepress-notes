package com.polymorphism.transition;

public class Main {
    public static void main(String[] args) {
        /*向上转型*/
        Animal animal = new Cat("小花");
        animal.run();
        Animal animal2 = new Dog("小黄");
        animal2.run();
        /*向上转型之后，不能访问到子类特有的成员*/
        /*animal.eat();*/
        /*报错：
        * java: 找不到符号
            符号:   方法 eat()
            位置: 类型为com.polymorphism.transition.Animal的变量 animal*/
        /*向下转型
        * 相当于重新声明了一个子类对象，将之前的animal转型赋值给这个子类对象*/
        Cat cat = (Cat) animal;
        cat.eat();
        /*animal依然存在，没有被销毁*/
        animal.run();
    }
}
