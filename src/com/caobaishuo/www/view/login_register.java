package com.caobaishuo.www.view;

import com.caobaishuo.www.dao.Admin;
import com.caobaishuo.www.dao.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login_register extends JFrame {
    public login_register(){
        init();
    }
    //登录界面初始化
   public void init(){
        JFrame jFrame=new JFrame("登录");
        jFrame.setLayout(null);
        JLabel nameStr=new JLabel("账号");
        nameStr.setBounds(250,200,100,25);
        jFrame.add(nameStr);
        JLabel passWordStr=new JLabel("密码");
        passWordStr.setBounds(250,250,150,25);
        jFrame.add(passWordStr);
        JTextField userID=new JTextField();
        userID.setBounds(300,200,150,25);
        jFrame.add(userID);
        JPasswordField passWord=new JPasswordField();
        passWord.setBounds(300,250,150,25);
        jFrame.add(passWord);
        JButton buttonLogin=new JButton("登录");
        buttonLogin.setBounds(275,300,70,25);
        jFrame.add(buttonLogin);
        JButton buttonRegister=new JButton("注册");
        buttonRegister.setBounds(375,300,70,25);
        jFrame.add(buttonRegister);
        jFrame.setBounds(400,100,800,650);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        //为按钮添加监听
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID=userID.getText();
                String password=new String(passWord.getPassword());
                //创建一个Admin用户，把输入框中的用户名密码提取出来

                Admin.setUsername(ID);
                Admin.setPassword(password);
                //登录
                Login login=new Login();
        //调用JudgeAdmin方法判断账号密码是否正确
                if(login.JudgeAdmin()==0){
                    JOptionPane.showMessageDialog(null,"账号或者密码错误","账号或密码错误",JOptionPane.WARNING_MESSAGE);
                    passWord.setText("");
                    userID.setText("");
                }else{
                    JOptionPane.showMessageDialog(null,"登陆成功","登陆成功", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        MainInterface.main();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    jFrame.setVisible(false);
                }
            }
        });
        //为注册按钮添加相应
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                AdminRegister ar=new AdminRegister();
            }
        });
   }
    //程序运行
    public static void main(String[] args) {
        login_register login_register=new login_register();
    }

}