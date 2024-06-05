package com.interfac.scenario;

/*
 * 给出我们的需求：
 *       我们需要连接三种数据库：MySQL，MongoDB、Oracle
 *       开发三个类，每个类中都要有连接和断开对应数据库的方法
 * */
// 使用接口，交给三个程序员来开发对应的类
public class Main2 {
    public static void main(String[] args) {
        /*1、我们发现三个程序员接和断开的方法名称被接口统一了
         * 2、再者我们调用连接和断开方法时，统一一套代码都能够调用*/
        test(new Mysql2());
        test(new MongoDB2());
        test(new Oracle2());
    }

    public static void test(DB db){
        db.connect();
        db.disconnection();
    }
}
// 定义一个数据库连接接口，里面必须要有连接和断开的方法
interface DB {
    public void connect();
    public void disconnection();
}

class Mysql2 implements DB{
    //    连接MySQL
    public void connect() {
        System.out.println("连接mysql");
    }

    //    断开MySQL
    public void disconnection() {
        System.out.println("断开mysql");
    }
}

class MongoDB2 implements DB{
    public void connect() {
        System.out.println("连接MongoDB");

    }

    public void disconnection() {
        System.out.println("断开MongoDB");
    }
}

class Oracle2 implements DB{
    public void connect() {
        System.out.println("连接Oracle");

    }

    public void disconnection() {
        System.out.println("断开Oracle");
    }
}
