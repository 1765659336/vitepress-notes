package com.extends_;

public class Main {
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        /*公共的成员变量可以直接访问*/
        System.out.println(son1.species);
        /*父类私有成员变量，可以被继承，但是不能被直接访问，只能通过公共的方法拿到*/
        System.out.println(son1.getSalary());
    }
}
