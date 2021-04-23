package com.caobaishuo.www.view;

import com.caobaishuo.www.view.PersonalCenter;
import com.caobaishuo.www.service.PasswordModificationInterfaceMethod;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordModificationInterface extends JFrame {
    PasswordModificationInterface(){
        init();
    }
    //创建修改密码界面
    public void init(){
        JFrame jFrame=new JFrame("修改密码");
        jFrame.setLayout(null);
        JLabel jLabel=new JLabel("密码");
        jLabel.setBounds(100,50,50,50);
        jFrame.add(jLabel);
        JLabel jLabel1=new JLabel("确认秘密");
        jLabel1.setBounds(100,140,80,50);
        jFrame.add(jLabel1);
        JButton jButton=new JButton("确定修改");
        jButton.setBounds(150,280,100,50);
        jFrame.add(jButton);
        JPasswordField jPasswordField=new JPasswordField();
        jPasswordField.setBounds(150,60,100,30);
        jFrame.add(jPasswordField);
        JPasswordField jPasswordField1=new JPasswordField();
        jPasswordField1.setBounds(150,150,100,30);
        jFrame.add(jPasswordField1);

        jButton.addActionListener(new ActionListener() {     //为按钮添加响应
            @Override
            public void actionPerformed(ActionEvent e) {
                String passWord=new String (jPasswordField.getPassword());       //定义变量并赋值
                String cPassWord=new String(jPasswordField1.getPassword());
                PasswordModificationInterfaceMethod passwordModificationInterfaceMethod=new PasswordModificationInterfaceMethod();
                passwordModificationInterfaceMethod.setPassWord(passWord);
                passwordModificationInterfaceMethod.setcPassWord(cPassWord);
                try {
                    if(passwordModificationInterfaceMethod.JudgePassWord()){     //调用JudgePassWord方法判断，修改成功则返回个人中心
                        jFrame.setVisible(false);

                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        jFrame.setBounds(400, 400, 400, 400);
        jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
