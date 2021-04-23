package com.caobaishuo.www.service;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {
    //创建变量并用getter和setter方法
    public String getID() {
        return username;
    }

    public void setID(String ID) {
        this.username = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassWord() {
        return confirmPassWord;
    }

    public void setConfirmPassWord(String confirmPassWord) {
        this.confirmPassWord = confirmPassWord;
    }

    public int getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        StudentNumber = studentNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    String c;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;
    String password;
    String confirmPassWord;
    int StudentNumber;
    String major;
    String grade;
    String name;

    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/db1?characterEncoding=utf8";
    private final String user="root";
    private final String sqlPassWord="320311";
    //判断注册的账号是否符合规则
    public boolean JudgeRegister() throws ClassNotFoundException {
        if(this.username.equals("")){
            JOptionPane.showMessageDialog(null,"账号不能为空！","账号为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        if(this.password.equals("")){
            JOptionPane.showMessageDialog(null,"密码不能为空","密码为空",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!this.password.equals(this.confirmPassWord)){
            JOptionPane.showMessageDialog(null,"两次输入的密码不一样","密码不一致",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null,"注册成功");
            addAdmin();
        return true;
    }
    void addAdmin() throws ClassNotFoundException {
        String sql="insert into user (username,password,StudentNumber,major,grade,name,class) values (?,?,?,?,?,?,?)";
        Class.forName(driver);     //驱动注册
        try {
            Connection conn= DriverManager.getConnection(url,user,sqlPassWord);   //连接数据库
            PreparedStatement ps=conn.prepareStatement(sql);         //输入sql语句
            ps.setString(1,this.username);
            ps.setString(2,this.password);
            ps.setInt(3,this.StudentNumber);
            ps.setString(4,this.major);
            ps.setString(5,this.grade);
            ps.setString(6,this.name);
            ps.setString(7,this.c);
            ps.executeUpdate();                                  //执行sql语句
            ps.close();                             //关闭资源
            conn.close();
        } catch (SQLException e) {
           System.out.println("添加用户失败");
        }

    }

}
