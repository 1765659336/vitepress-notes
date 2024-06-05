package com.Collection_;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_ {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new People("zhangsan", 18.5, "nan"));
        arrayList.add(new People("zhangsan", 20, "nan"));
        arrayList.add(new People("zhangsan", 21.5, "nan"));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        /*注意：迭代器执行完毕之后，指针已经指到最后一个元素了，需要重置迭代器。
         *否则使用iterator.next()去拿第一个值时会抛出NoSuchElementException异常 */
        iterator = arrayList.iterator();
        Object next = iterator.next();
        System.out.println(next);
    }
}

class People {
    private String name;
    private double age;
    private String sex;

    public People(String name, double age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
