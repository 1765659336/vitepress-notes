package com.extends_;

public class Main3 {
    public static void main(String[] args) {
        Son3 son3 = new Son3("zhangsan");
        Son3 son32 = new Son3("lisi",18);
        System.out.println(son3.name+son3.age+son3.money);
        System.out.println(son32.name+son32.age+son32.money);
    }
}
