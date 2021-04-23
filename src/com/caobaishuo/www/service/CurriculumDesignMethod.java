package com.caobaishuo.www.service;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CurriculumDesignMethod {
    //定义变量并给与方法

        public  String getCourseTitle() {
            return courseTitle;
        }

        public  void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }

        public  String getType() {
            return type;
        }

        public  void setType(String type) {
            this.type = type;
        }

        public  String getClassroom() {
            return classroom;
        }

        public  void setClassroom(String classroom) {
            this.classroom = classroom;
        }

        public  String getCode() {
            return Code;
        }

        public  void setCode(String code) {
            Code = code;
        }
        private String courseTitle;
      private   String type;
      private   String classroom;
      private   String Code;
      private   String teacher;

        public  String getTeacher() {
            return teacher;
        }

        public  void setTeacher(String teacher) {
            this.teacher = teacher;
        }

            //数据库连接
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/db1?characterEncoding=utf8";
    private final String user="root";
    private final String sqlPassWord="320311";
    public boolean JudgeSet() throws Exception {      //判断班级设置是否规范
        if(this.classroom.equals("")){
            JOptionPane.showMessageDialog(null,"班级不能为空！","班级为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        if (this.Code.equals("")){
            JOptionPane.showMessageDialog(null,"代号不能为空！","代号为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        if (this.courseTitle.equals("")){
            JOptionPane.showMessageDialog(null,"课程名不能为空！","课程名为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        if (this.type.equals("")){
            JOptionPane.showMessageDialog(null,"课程类型不能为空！","课程类型为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        if(this.teacher.equals("")){
            JOptionPane.showMessageDialog(null,"教师名不能为空！","教师名为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        JOptionPane.showMessageDialog(null,"设置成功");
        add();
        return true;
    }
    void add() throws Exception {
        String sql="insert into curriculum (Code,teacher,classroom,type,CourseTitle) values (?,?,?,?,?)";
        Class.forName(driver);
        try{
        Connection conn= DriverManager.getConnection(url,user,sqlPassWord);
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,this.Code);
        ps.setString(2,this.teacher);
        ps.setString(3,this.classroom);
        ps.setString(4,this.type);
        ps.setString(5,this.courseTitle);
        ps.executeUpdate();
        ps.close();
        conn.close();
        }
        catch (SQLException e) {
            System.out.println("添加用户失败");
        }
    }
}
