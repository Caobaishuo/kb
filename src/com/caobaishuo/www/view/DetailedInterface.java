package com.caobaishuo.www.view;

import javax.swing.*;

public class DetailedInterface extends JFrame {
    //定义变量,生成getter和setter方法
    String title;
    String teacher;
    String time;
    String room;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
         //显示细节的界面
    public  void main() {
        JFrame jFrame=new JFrame("详细");
        jFrame.setLayout(null);
        jFrame.setBounds(400,400,350,350);
        JLabel jLabel=new JLabel("课程名："+this.title);
        jLabel.setBounds(50,50,200,50);
        jFrame.add(jLabel);
        JLabel jLabel1=new JLabel("老师："+this.teacher);
        jLabel1.setBounds(50,100,200,50);
        jFrame.add(jLabel1);
        JLabel jLabel2=new JLabel("时间："+this.time);
        jLabel2.setBounds(50,150,200,50);
        jFrame.add(jLabel2);
        JLabel jLabel3=new JLabel("教室："+this.room);
        jLabel3.setBounds(50,200,200,50);
        jFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jFrame.add(jLabel3);
        jFrame.setVisible(true);
    }

}
