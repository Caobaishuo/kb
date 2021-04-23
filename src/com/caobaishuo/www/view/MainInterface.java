package com.caobaishuo.www.view;

import com.caobaishuo.www.dao.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainInterface extends JFrame {
    MainInterface() throws Exception {
        init();
    }
      //主界面创建
    public void init() throws Exception {
        JFrame jFrame=new JFrame("课表");
        jFrame.setLayout(null);
        jFrame.setBounds(400,100,1010,750);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTabbedPane jTabbedPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT); //添加选项面板
        jTabbedPane.addTab("第1周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",1));
        jTabbedPane.addTab("第2周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",2));
        jTabbedPane.addTab("第3周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",3));
        jTabbedPane.addTab("第4周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",4));
        jTabbedPane.addTab("第5周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",5));
        jTabbedPane.addTab("第6周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",6));
        jTabbedPane.addTab("第7周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",7));
        jTabbedPane.addTab("第8周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",8));
        jTabbedPane.addTab("第9周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",9));
        jTabbedPane.addTab("第10周",createTextPanel("       星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",10));
        jTabbedPane.addTab("第11周",createTextPanel("      星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",11));
        jTabbedPane.addTab("第12周",createTextPanel("      星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",12));
        jTabbedPane.addTab("第13周",createTextPanel("      星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",13));
        jTabbedPane.addTab("第14周",createTextPanel("      星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",14));
        jTabbedPane.addTab("第15周",createTextPanel("      星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",15));
        jTabbedPane.addTab("第16周",createTextPanel("      星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",16));
        jTabbedPane.addTab("第17周",createTextPanel("      星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",17));
        jTabbedPane.addTab("第18周",createTextPanel("      星期一                              星期二                              星期三                              星期四                              星期五                              星期六                              星期日",18));
        jTabbedPane.setSelectedIndex(0);
        jFrame.setContentPane(jTabbedPane);
        jFrame.setVisible(true);
    }
      //每个面板现实的内容
   public  JComponent createTextPanel(String text,int x) throws Exception {
        JPanel panel=new JPanel(null);
        JLabel label=new JLabel(text);
        label.setBounds(10,0,980,50);
        JButton jButton=new JButton("个人中心");            //设置一个按钮并命名为个人中心
        jButton.setBounds(887,0,100,100);
        jButton.addActionListener(new ActionListener() {             //给按钮添加响应，点击会执行PersonalCenter.main方法
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonalCenter.main();
            }
        });
        JButton jButton1=new JButton("搜索课程");
        jButton1.setBounds(887,100,100,100);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchInterface.main();
            }
        });
        JButton jButton2=new JButton("课程设置");
        jButton2.setBounds(887,200,100,100);
        panel.add(jButton2);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Admin.getStudentNumber().equals("teacher")) {
                    CurriculumDesign curriculumDesign = new CurriculumDesign();
                }else {
                    JOptionPane.showMessageDialog(null,"只有教师才能设置课程！","您不是教师",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton jButton3=new JButton("选课");
        jButton3.setBounds(887,300,100,100);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurriculumChoiceInterface.main();
            }
        });
        final String driver="com.mysql.cj.jdbc.Driver";
        final String url="jdbc:mysql://localhost:3306/db1?characterEncoding=utf8";
        final String user="root";
        final String sqlPassWord="320311";
        int number1;
        String week="'第"+x+"周'";
        int X=0;
       Class.forName(driver);
       Connection conn = DriverManager.getConnection(url, user, sqlPassWord);
        for (number1=1;number1<=7;number1++) {
            String day="'星期"+number1+"'";
            String sql = "SELECT * FROM id_curriculum,curriculum WHERE id_curriculum.curriculum_id=curriculum.Code AND user_id=" + Admin.getStudentNumber() + " AND week=" + week + " AND day=" + day;
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            int y = 100;
            while (rs.next()) {
                String time = rs.getString("time");
                String teacher = rs.getString("teacher");
                String room = rs.getString("classroom");
                String title = rs.getString("CourseTitle");
                JButton jButton5 = new JButton(title);
                jButton5.setBounds(X, y, 126, 100);
                panel.add(jButton5);
                jButton5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      DetailedInterface detailedInterface=new DetailedInterface();
                      detailedInterface.setRoom(room);
                      detailedInterface.setTeacher(teacher);
                      detailedInterface.setTitle(title);
                      detailedInterface.setTime(time);
                      detailedInterface.main();
                    }
                });
                y += 100;
            }
            X+=127;
            rs.close();
            ps.close();
        }
            conn.close();
        panel.add(jButton3);
        panel.add(jButton1);
        panel.add(jButton);
        panel.add(label);
        return panel;
   }

    public static void main() throws Exception {
        MainInterface mainInterface=new MainInterface();
    }
}
