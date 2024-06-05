package com.Set_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        /*
        定义一个Employee类，该类包含private成员属性name,age,MyDate类型的birthday 要求：
        创建三个Employee对象放在HashSet中
        当name,age,birthday的值相同时，认为是同一个员工，不能添加到HashSet集合中
        * */
        Employee zhangsan = new Employee("zhangsan", 18);
        Employee lisi = new Employee("lisi", 19);
        Employee wangwu = new Employee("wangwu", 20);
        Employee zhangsan2 = new Employee("zhangsan",18);
        Set set = new HashSet();
        set.add(zhangsan);
        set.add(lisi);
        set.add(wangwu);
        set.add(zhangsan2);
        for (Object o :set) {
            System.out.println(o);
        }


    }
}

class Employee {
    private String name;
    private double age;
    private MyDate birthday;

    class MyDate {
        private int year;
        private int month;
        private int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyDate myDate = (MyDate) o;
            return Objects.equals(year, myDate.year) && Objects.equals(month, myDate.month) && Objects.equals(day, myDate.day);
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }

        @Override
        public String toString() {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}';
        }
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

    public Employee(String name, double age) {
        this.name = name;
        this.age = age;
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atTime(LocalTime.now());
        this.birthday = new MyDate(localDateTime.getYear(),localDateTime.getMonthValue(),localDateTime.getDayOfMonth());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.age, age) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
