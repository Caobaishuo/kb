package com.caobaishuo.www.service;

import com.caobaishuo.www.dao.Admin;
import com.caobaishuo.www.dao.Login;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordModificationInterfaceMethod {
    //定义变量并连接驱动与数据库
    Login login=new Login();
    String passWord;
    String cPassWord;
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/db1";
    private final String user="root";
    private final String sqlPassWord="320311";

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getcPassWord() {
        return cPassWord;
    }

    public void setcPassWord(String cPassWord) {
        this.cPassWord = cPassWord;
    }
    public boolean JudgePassWord() throws Exception {
        if(this.passWord.equals("")){          //判断密码是否为空
            JOptionPane.showMessageDialog(null,"密码不能为空","密码为空",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!this.cPassWord.equals(passWord)){     //判断两次密码是否一致
            JOptionPane.showMessageDialog(null,"两次输入的密码不一样","密码不一致",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null,"修改成功");      //如果输入无错误则显示修改成功窗口
        addAdmin1();             //调用addAdmin1方法
        return true;
    }
    //向数据库中添加数据
    void addAdmin1() throws Exception {
        String sql="update user set password = ? where username = ?";
        Class.forName(driver);
        try {
            Connection conn= DriverManager.getConnection(url,user,sqlPassWord);
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,passWord);
            ps.setString(2, Admin.getUsername());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
