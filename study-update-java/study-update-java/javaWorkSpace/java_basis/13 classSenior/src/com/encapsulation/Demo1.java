package com.encapsulation;

public class Demo1 {
    public String name;
    private int age;
    private double salary;
    private String job;

    public Demo1(String name, int age, double salary,String job){
        setAge(age);
        setName(name);
        setJob(job);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setAge(int age){
        if(age > 0 && age < 120){
            this.age = age;
        }
        System.out.println("年龄不符合0到120岁之间，默认18岁");
        this.age = 18;
    }
    public int getAge(){
        return this.age;
    }
}
