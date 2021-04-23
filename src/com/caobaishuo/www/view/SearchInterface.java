package com.caobaishuo.www.view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.caobaishuo.www.dao.SearchMethod;
public class SearchInterface extends JFrame {
    //创建课程搜索界面
    public static void main() {
        JFrame jFrame=new JFrame("搜索课程");
        jFrame.setLayout(null);
        jFrame.setBounds(400,400,300,300);
        JTextField jTextField=new JTextField();
        jTextField.setBounds(70,50,150,40);
        jFrame.add(jTextField);
        JButton jButton=new JButton("确定");
        jButton.setBounds(75,110,80,50);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {     //为按钮添加响应,点击会创建一个类并调用里面的方法
                SearchMethod searchMethod=new SearchMethod();
                try {
                    searchMethod.search(jTextField.getText());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        jFrame.add(jButton);
        jFrame.setVisible(true);


    }

}
