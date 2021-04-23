package com.caobaishuo.www.view;
import com.caobaishuo.www.dao.Admin;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalCenter extends JFrame{
    //创建个人中心界面
    public static void main() {
        JFrame jFrame = new JFrame("个人中心");
        jFrame.setLayout(null);
        JButton jButton = new JButton("注销账户");
        jButton.setBounds(200, 300, 100, 50);
        jFrame.add(jButton);
        JButton jButton1 = new JButton("修改密码");
        jButton1.setBounds(100, 300, 100, 50);
        jFrame.add(jButton1);
        //定义变量并赋值
        String studentNumber = Admin.getStudentNumber();
        String grade = Admin.getGrade();
        String major = Admin.getMajor();
        String name = Admin.getName();
        JLabel jLabel = new JLabel("姓名：" + name);
        jLabel.setBounds(100, 10, 200, 70);
        jFrame.add(jLabel);
        JLabel jLabel1 = new JLabel("年级：" + major);
        jLabel1.setBounds(100, 80, 200, 70);
        jFrame.add(jLabel1);
        JLabel jLabel2 = new JLabel("专业：" + grade);
        jLabel2.setBounds(100, 150, 200, 70);
        jFrame.add(jLabel2);
        JLabel jLabel3 = new JLabel("学号：" + studentNumber);
        jLabel3.setBounds(100, 220, 200, 70);
        jFrame.add(jLabel3);
        jFrame.setBounds(400, 400, 400, 400);
        jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jFrame.setVisible(true);
        jButton1.addActionListener(new ActionListener() {     //为按钮添加响应，点击会显示修改密码界面
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordModificationInterface passwordModificationInterface=new PasswordModificationInterface();
            }
        });
        jButton.addActionListener(new ActionListener() {      // 为按钮添加响应，点击会调用ConfirmDeleteInterface.main方法
            @Override
            public void actionPerformed(ActionEvent e) {
                     ConfirmDeleteInterface.main();
            }
        });
    }
}
