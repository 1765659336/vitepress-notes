/*
    @说明:演示PreparedStatement的使用
*/
package com.preparedStatement_;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
//        String admin_name = scanner.next();
        String admin_name = scanner.nextLine();
        System.out.println("请输入密码");
//        String admin_pwd = scanner.next();
        String admin_pwd = scanner.nextLine();
        // 1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        /* 2、得到连接:
         *   */
        String url = "jdbc:mysql://localhost:3306/bjpowernode";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3、执行sql,?占位符
        String sql = "select name,pwd from admin where name = ? and pwd = ?";
        // 接收返回的结果对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,admin_name);
        preparedStatement.setString(2,admin_pwd);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            // 查询到用户
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        sql = "insert into admin values (?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,admin_name+"1");
        preparedStatement.setString(2,admin_pwd+"1");
        Integer i = preparedStatement.executeUpdate();
        System.out.println(i);
        // 4、关闭连接
        preparedStatement.close();
        connection.close();
        result.close();
        scanner.close();
    }
}
