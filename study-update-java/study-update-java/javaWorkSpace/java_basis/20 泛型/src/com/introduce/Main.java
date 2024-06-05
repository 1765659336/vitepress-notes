package com.introduce;

public class Main {
    public static void main(String[] args) {
        Person<String> person = new Person<>("2");
        System.out.println(person.say("1"));
    }
}

// 在新建对象编译时就确定了数据的类型
class Person<T>{
    private T name;
    public T say(T msg){
        System.out.println(msg);
        if (msg instanceof String){
            System.out.println("你传入的值是String");
        }
        return this.name;
    }

    public Person(T name) {
        this.name = name;
    }
}
