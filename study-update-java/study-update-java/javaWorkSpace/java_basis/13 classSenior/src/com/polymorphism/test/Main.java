package com.polymorphism.test;

public class Main {
    public static void main(String[] args) {
        People[] array = {new People(),new Student(18),new Teacher()};
        for (int i = 0; i < array.length; i++) {
            /* instanceof 判断运行时的类型,从而来调用子类特殊的成员 */
            if(array[i] instanceof Student){
                Student student = (Student) array[i];
                student.getAge();
            }
            array[i].speak();
        }
    }
}
