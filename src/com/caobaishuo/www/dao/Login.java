package com.caobaishuo.www.dao;

import com.caobaishuo.www.dao.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//登录方法
public class Login {
// 连接数据库操作
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/db1";
    private final String user="root";
    private final String password="320311";
    public  boolean login(Admin admin) throws Exception {
        String sql = "select * from user where username=? and password=?";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, Admin.getUsername());
        ps.setString(2, Admin.getPassword());
        ResultSet rs = ps.executeQuery();
        int ans = 0;
        //判断rs是否有结果返回
        if (rs.next()) {
            Admin.setName(rs.getString("name"));
            Admin.setMajor(rs.getString("major"));
            Admin.setGrade(rs.getString("grade"));
            Admin.setStudentNumber(rs.getString("StudentNumber"));
            ans = 1;
        }
        rs.close();
        ps.close();
        conn.close();
        if (ans == 1) {
            return true;
        } else {
            return false;
        }
    }
    //创建JudgeAdmin方法，判断Admin的Id和密码是否正确
    public int JudgeAdmin(){
            try {
                if(login(new Admin())) {
                    System.out.println("登录成功");
                    return 1;
                }else{
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

