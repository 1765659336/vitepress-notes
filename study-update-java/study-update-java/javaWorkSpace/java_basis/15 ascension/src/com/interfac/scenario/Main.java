package com.interfac.scenario;

/*
 * 给出我们的需求：
 *       我们需要连接三种数据库：MySQL，MongoDB、Oracle
 *       开发三个类，每个类中都要有连接和断开对应数据库的方法
 * */
// 不使用接口，交给三个程序员来开发对应的类
public class Main {
    public static void main(String[] args) {
        /*1、我们发现三个程序员可能声明的连接和断开的方法名称不一致
        * 2、再者我们调用连接和断开方法时，不能统一一套代码都能够调用*/
        Mysql1 mysql1 = new Mysql1();
        MongoDB1 mongoDB1 = new MongoDB1();
        Oracle1 oracle1 = new Oracle1();
        mysql1.connect();
        mongoDB1.start();
        oracle1.link();
        mysql1.disconnection();
        mongoDB1.end();
        oracle1.shotDowm();
    }
}

class Mysql1 {
    //    连接MySQL
    public void connect() {
        System.out.println("连接mysql");
    }

    //    断开MySQL
    public void disconnection() {
        System.out.println("断开mysql");
    }
}

class MongoDB1 {
    public void start() {
        System.out.println("连接MongoDB");
    }

    public void end() {
        System.out.println("断开MongoDB");
    }
}

class Oracle1 {
    public void link(){
        System.out.println("连接Oracle");
    }
    public void shotDowm(){
        System.out.println("断开Oracle");
    }
}
