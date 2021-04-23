package com.caobaishuo.www.dao;

import com.caobaishuo.www.dao.Admin;
import com.caobaishuo.www.view.login_register;
import javax.swing.*;
import java.sql.*;

public class DeleteAccount {
    //连接数据库并设置sql语句
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/db1";
    private final String user="root";
    private final String password="320311";
    String sql="delete from user where username = ?";
    String sql1="set foreign_key_checks=0";     // 使外键连接失效
    String sql2="set foreign_key_checks=1";     //使外键连接成功
    //删除数据
    public  void delete() throws Exception {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement ps1=conn.createStatement();
        ps1.executeQuery(sql1);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, Admin.getUsername());
        int rs=ps.executeUpdate();
        Statement ps2=conn.createStatement();
        ps2.executeQuery(sql2);
        if(rs!=0){
            JOptionPane.showMessageDialog(null,"注销成功");
            login_register login_register=new login_register();
        }

    }
}
