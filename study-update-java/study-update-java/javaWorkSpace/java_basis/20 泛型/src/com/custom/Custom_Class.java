package com.custom;

public class Custom_Class {
    public static void main(String[] args) {
        Emplee<String, Double> objectObjectEmplee = new Emplee<>("zhangsan",18d, new String[]{"1", "2", "3"});
        System.out.println(objectObjectEmplee.getName()+"-"+objectObjectEmplee.getAge());
        for (Object o :objectObjectEmplee.getArr()) {
            System.out.println(o);
        }
    }
}

class Emplee<T,D> {
    private T name;
    private D age;
    private T[] arr;

/*//    编译报错：java: 无法从静态上下文中引用非静态 类型变量 T
    public static void say(T str){
        System.out.println(str);
    }*/

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public D getAge() {
        return age;
    }

    public void setAge(D age) {
        this.age = age;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public Emplee(T name, D age, T[] arr) {
        setName(name);
        setAge(age);
        setArr(arr);
    }
}