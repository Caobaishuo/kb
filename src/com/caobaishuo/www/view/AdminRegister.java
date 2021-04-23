package com.caobaishuo.www.view;

import com.caobaishuo.www.service.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRegister extends JFrame {
    AdminRegister(){
        init();
    }
    void init(){
        //注册界面代码
        JFrame jFrame=new JFrame("注册账号");
        jFrame.setLayout(null);
        JLabel userName=new JLabel("姓名");
        userName.setBounds(250,150,100,25);
        jFrame.add(userName);
        JTextField userNameStr=new JTextField();
        userNameStr.setBounds(320,150,150,25);
        jFrame.add(userNameStr);
        JLabel major=new JLabel("专业");
        major.setBounds(250,100,100,25);
        jFrame.add(major);
        JTextField majorStr=new JTextField();
        majorStr.setBounds(320,100,150,25);
        jFrame.add(majorStr);
        JLabel grade=new JLabel("年级");
        grade.setBounds(250,50,100,25);
        jFrame.add(grade);
        JTextField gradeStr=new JTextField();
        gradeStr.setBounds(320,50,150,25);
        jFrame.add(gradeStr);
        JLabel StudentNumber=new JLabel("学号");
        StudentNumber.setBounds(250,350,100,25);
        jFrame.add(StudentNumber);
        JTextField StudentNumberStr=new JTextField();
        StudentNumberStr.setBounds(320,350,150,25);
        jFrame.add(StudentNumberStr);
        JLabel IDStr=new JLabel("账号");
        IDStr.setBounds(250,200,100,25);
        jFrame.add(IDStr);
        JLabel passWordStr=new JLabel("密码");
        passWordStr.setBounds(250,250,100,25);
        jFrame.add(passWordStr);
        JLabel confirmStr=new JLabel("确定密码");
        confirmStr.setBounds(250,300,100,30);
        jFrame.add(confirmStr);
        JTextField userID=new JTextField();
        userID.setBounds(320,200,150,25);
        jFrame.add(userID);
        JPasswordField passWord=new JPasswordField();
        passWord.setBounds(320,250,150,25);
        jFrame.add(passWord);
        JPasswordField confirmPassWord=new JPasswordField();
        confirmPassWord.setBounds(320,300,150,25);
        jFrame.add(confirmPassWord);
        JLabel jLabel=new JLabel("班级");
        jLabel.setBounds(250,400,100,25);
        jFrame.add(jLabel);
        JTextField jTextField=new JTextField();
        jTextField.setBounds(320,400,150,25);
        jFrame.add(jTextField);
        JButton buttonRegister=new JButton("注册");
        buttonRegister.setBounds(350,500,70,25);
        jFrame.add(buttonRegister);
        jFrame.setBounds(400,100,800,650);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        //为注册按钮添加监听器
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将输入框的值赋给变量
                String grade= gradeStr.getText();
                String major= majorStr.getText();
                String name= userNameStr.getText();
                String StudentNumber= StudentNumberStr.getText();
                String ID= userID.getText();
                String passwd=new String(passWord.getPassword());
                String confirmPasswd=new String(confirmPassWord.getPassword());
                String C=jTextField.getText();
                //创建一个Register类，并对Register类中的值进行赋值
                Register register=new Register();
                register.setMajor(major);
                register.setGrade(grade);
                register.setName(name);
                register.setStudentNumber(Integer.parseInt(StudentNumber));
                register.setID(ID);
                register.setPassword(passwd);
                register.setConfirmPassWord(confirmPasswd);
                register.setC(C);
                try {
                    //调用JudgeRegister方法判断注册是否符合要求
                    if(register.JudgeRegister()){
                        jFrame.setVisible(false);           //设置注册界面不可见
                        login_register login_register=new login_register();         //显示登录主界面
                    }
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
    }
}
