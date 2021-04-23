package com.caobaishuo.www.view;

import com.caobaishuo.www.view.PersonalCenter;
import com.caobaishuo.www.dao.DeleteAccount;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//创建一个确认注销账户的界面
public class ConfirmDeleteInterface extends JFrame {
    public static void main() {
        JFrame jFrame=new JFrame("确认");
        jFrame.setLayout(null);
        JLabel jLabel=new JLabel("你是否要注销账户？");
        jLabel.setBounds(100,100,200,100);
        jFrame.add(jLabel);
        JButton jButton=new JButton("是");
        jButton.setBounds(100,200,50,50);
        jFrame.add(jButton);
        JButton jButton1=new JButton("否");
        jButton1.setBounds(150,200,50,50);
        jFrame.add(jButton1);
        jFrame.setBounds(400,400,400,400);
        jFrame.setVisible(true);
        jButton.addActionListener(new ActionListener() {            //为按钮添加响应
            @Override
            public void actionPerformed(ActionEvent e) {               //创建一个类并执行里面的删除方法
                DeleteAccount deleteAccount=new DeleteAccount();
                try {
                    deleteAccount.delete();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonalCenter.main();
            }
        });
    }


}
