/*
    @说明: 练习preparedStatement的使用
*/
package com.preparedStatement_;

import java.sql.*;

public class Practice {
    /*
    * create table admin(id int primary key auto_increment,name varchar(32) not null,pwd varchar(32) not null);
insert into admin(name,pwd) values ('tom','123456'),('lisi','123456'),('li3si','123456'),('li4si','123456'),('lis2i','123456');
update admin set name='king' where name = 'tom';
delete from admin where name = 'lisi';
select * from admin;*/
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        /* 2、得到连接:
         *   */
        String url = "jdbc:mysql://localhost:3306/bjpowernode";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3、执行sql
        String sql = "create table admin(id int primary key auto_increment,name varchar(32) not null,pwd varchar(32) not null);";
        String sqlS = "select * from admin;";
        // 接收返回的结果对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        sql = "insert into admin(name,pwd) values ('tom','123456'),('lisi','123456'),('li3si','123456'),('li4si','123456'),('lis2i','123456');";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        sql = "update admin set name='king' where name = 'tom';";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        sql = "delete from admin where name = 'lisi';";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        preparedStatement = connection.prepareStatement(sqlS);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            // 查询到用户
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        // 4、关闭连接
        preparedStatement.close();
        connection.close();
        result.close();
    }
}
