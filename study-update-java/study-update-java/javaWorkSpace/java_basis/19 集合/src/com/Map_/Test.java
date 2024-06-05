package com.Map_;

import java.security.Permission;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        /*
        * Map接口课堂练习
        使用HashMap添加3个员工对象
        要求
        键:员工id
        值:员工对象
        并遍历显示工资>18000的员工(
        遍历方式最少两种)
        员工类:姓名、工资
        */
        Map map = new HashMap();
        map.put("id1", new Personnel("id1","zhangsan",30000));
        map.put("id2",new Personnel("id2","lisi",20000));
        map.put("id3",new Personnel("id3","wangwu",10000));
        Set keyset = map.keySet();
        for (Object o :keyset) {
            Personnel personnel = (Personnel) map.get(o);
            if(personnel.getSalary() > 18000){
                System.out.println(personnel);
            }
        }
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            if(((Personnel)map.get(next)).getSalary()>18000){
                System.out.println(map.get(next));
            }
        }
    }
}

class Personnel {
    private String name;
    private double salary;
    private String id;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Personnel(String id,String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}
