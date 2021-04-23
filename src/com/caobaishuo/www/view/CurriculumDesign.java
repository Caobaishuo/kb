package com.caobaishuo.www.view;

import com.caobaishuo.www.service.CurriculumDesignMethod;
import com.caobaishuo.www.view.MainInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurriculumDesign extends JFrame {
    CurriculumDesign() {
     init ();}
     //显示课程设置界面
     void init(){
            JFrame jFrame = new JFrame("课程设置");
            jFrame.setLayout(null);
            jFrame.setBounds(400, 400, 450, 700);
            JLabel jLabel = new JLabel("课名");
            jLabel.setBounds(100, 50, 50, 50);
            jFrame.add(jLabel);
            JTextField jTextField = new JTextField();
            jTextField.setBounds(150, 55, 150, 35);
            jFrame.add(jTextField);
            JLabel jLabel1 = new JLabel("教室");
            jLabel1.setBounds(100, 150, 50, 50);
            jFrame.add(jLabel1);
            JTextField jTextField1 = new JTextField();
            jTextField1.setBounds(150, 155, 150, 35);
            jFrame.add(jTextField1);
            JLabel jLabel2 = new JLabel("类型");
            jLabel2.setBounds(100, 250, 150, 35);
            jFrame.add(jLabel2);
            JTextField jTextField2 = new JTextField();
            jTextField2.setBounds(150, 255, 150, 35);
            jFrame.add(jTextField2);
            JLabel jLabel3 = new JLabel("课程代码");
            jLabel3.setBounds(100, 350, 150, 35);
            jFrame.add(jLabel3);
            JTextField jTextField3 = new JTextField();
            jTextField3.setBounds(150, 355, 150, 35);
            jFrame.add(jTextField3);
            JLabel jLabel4 = new JLabel("教师");
            jLabel4.setBounds(100, 450, 150, 35);
            jFrame.add(jLabel4);
            JTextField jTextField4 = new JTextField();
            jTextField4.setBounds(150, 455, 150, 35);
            jFrame.add(jTextField4);
            JButton jButton = new JButton("确定");
            jButton.setBounds(165, 550, 100, 60);
            jFrame.add(jButton);
            jFrame.setVisible(true);

            jButton.addActionListener(new ActionListener() {      //为按钮添加响应
                   @Override
                   public void actionPerformed(ActionEvent e) {
                          //定义变量并将输入框中的值赋给变量
                          String classroom=jTextField1.getText();
                          String courseTitle=jTextField.getText();
                          String type=jTextField2.getText();
                          String code=jTextField3.getText();
                          String teacher=jTextField4.getText();
                          //创建一个CurriculumDesignMethod类，并设置里面的变量值
                          CurriculumDesignMethod curriculumDesignMethod=new CurriculumDesignMethod();
                          curriculumDesignMethod.setClassroom(classroom);
                          curriculumDesignMethod.setCourseTitle(courseTitle);
                          curriculumDesignMethod.setType(type);
                          curriculumDesignMethod.setCode(code);
                          curriculumDesignMethod.setTeacher(teacher);
                          try {
                            if(curriculumDesignMethod.JudgeSet()){       //调用JudgeSet方法
                                   jFrame.setVisible(false);
                            }
                          } catch (Exception exception) {
                                 exception.printStackTrace();
                          }
                   }
            });
        }
    }

