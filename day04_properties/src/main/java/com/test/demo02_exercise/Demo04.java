package com.test.demo02_exercise;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: Jface
 * @Date: 2021/5/23 20:09
 * @Desc:
案例: 演示JDBC的CURD操作.
JDBC的核心操作步骤:
0. 导入驱动,  其实就是导入jar包, 只要做一次就行.
1. 注册驱动.
2. 获取连接对象.
3. 根据连接对象, 获取可以执行SQL语句的对象.
4. 执行SQL语句, 获取结果集.
5. 操作结果集.
6. 释放资源.
 */
public class Demo04 {

    //JDBC的 查 的动作.
@Test
    public void show1() throws Exception {
//    1. 注册驱动.
    Class.forName("com.mysql.jdbc.Driver");
//    2. 获取连接对象.
    Connection conn =DriverManager.getConnection("jdbc:mysql:///day16","root","root");
//    3. 根据连接对象, 获取可以执行SQL语句的对象.
    Statement stat = conn.createStatement();
//    4. 执行SQL语句, 获取结果集.
    String sql = "select * from users;";
    ResultSet rs = stat.executeQuery(sql);
//    5. 操作结果集.
    while(rs.next())
        System.out.println(rs.getInt("uid")+", "+rs.getString("username")+", "+rs.getString("password"));
//    6. 释放资源.
    rs.close();
    stat.close();
    conn.close();

}
    //JDBC的 增 的动作.
    @Test
    public void show2() throws Exception {
//        1. 注册驱动.
        Class.forName("com.mysql.jdbc.Driver");
//        2. 获取连接对象.
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day16","root","root");
//        3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
//        4. 执行SQL语句, 获取结果集.
        String sql = "insert into users values (null,'gaoyuanyuan','gyy')";
//        5. 操作结果集.
        int rs = stat.executeUpdate(sql);
        System.out.println((rs>0)?"添加成功":"添加失败");
//        6. 释放资源.
        stat.close();
        conn.close();
    }

    //JDBC的 改 的动作.
    @Test
    public void show3() throws Exception {
//        1. 注册驱动.
        Class.forName("com.mysql.jdbc.Driver");
//        2. 获取连接对象.
        Connection conn =DriverManager.getConnection("jdbc:mysql:///day16","root","root");
//        3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
//        4. 执行SQL语句, 获取结果集.
        String sql ="update users set username='baijuyi',password='bjy' where uid = 3 ;";
        int i = stat.executeUpdate(sql);
//        5. 操作结果集.
        System.out.println((i>0)?"修改成功":"修改失败");
//        6. 释放资源.
    }

    //JDBC的 删 的动作.
    @Test
    public void show4() throws Exception{
//        1. 注册驱动.
        Class.forName("com.mysql.jdbc.Driver");
//        2. 获取连接对象.
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day16","root","root");
//        3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
//        4. 执行SQL语句, 获取结果集.
        String sql ="delete from users where uid = 4 ";
        int i = stat.executeUpdate(sql);
//        5. 操作结果集.
        System.out.println((i>0)?"删除成功":"删除失败");
//        6. 释放资源.
        stat.close();
        conn.close();
    }

}
