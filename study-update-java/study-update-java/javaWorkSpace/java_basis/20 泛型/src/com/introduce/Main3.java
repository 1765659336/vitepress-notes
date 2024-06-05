package com.introduce;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList<Employee>();
        list.add(new Employee("zhangsan", 18));
        TimeUnit.SECONDS.sleep(1);
        list.add(new Employee("zhangsan", 18));
        list.add(new Employee("lisi", 20));
        list.add(new Employee("wangwu", 20));
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (((Employee) o1).getName() != ((Employee) o2).getName()) {
                    return ((Employee) o1).getName().length() - ((Employee) o2).getName().length();
                } else if (((Employee.MyDate) ((Employee) o1).getBirthday()).getYear() != ((Employee.MyDate) ((Employee) o2).getBirthday()).getYear()) {
                    return ((Employee.MyDate) ((Employee) o1).getBirthday()).getYear() - ((Employee.MyDate) ((Employee) o2).getBirthday()).getYear();
                } else if (((Employee.MyDate) ((Employee) o1).getBirthday()).getMonth() != ((Employee.MyDate) ((Employee) o2).getBirthday()).getMonth()) {
                    return ((Employee.MyDate) ((Employee) o1).getBirthday()).getMonth() - ((Employee.MyDate) ((Employee) o2).getBirthday()).getMonth();
                } else if(((Employee.MyDate) ((Employee) o1).getBirthday()).getDay() != ((Employee.MyDate) ((Employee) o2).getBirthday()).getDay()){
                    return ((Employee.MyDate) ((Employee) o1).getBirthday()).getDay() - ((Employee.MyDate) ((Employee) o2).getBirthday()).getDay();
                }
                return ((Employee.MyDate) ((Employee) o1).getBirthday()).getSecond() - ((Employee.MyDate) ((Employee) o2).getBirthday()).getSecond();
            }
        });
        System.out.println(list);
    };
};

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, double sal) {
        setName(name);
        setSal(sal);
        setBirthday(new MyDate());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    class MyDate {
        private int year;
        private int month;
        private int day;
        private int second;

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
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

        public MyDate() {
            LocalDate localDate = LocalDate.now();
            LocalDateTime localDateTime = localDate.atTime(LocalTime.now());
            setYear(localDateTime.getYear());
            setMonth(localDateTime.getDayOfMonth());
            setDay(localDateTime.getDayOfMonth());
            setSecond(localDateTime.getSecond());
        }

        @Override
        public String toString() {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    ", second=" + second +
                    '}';
        }
    }
}

