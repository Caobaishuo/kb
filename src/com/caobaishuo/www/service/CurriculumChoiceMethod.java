package com.caobaishuo.www.service;
import com.caobaishuo.www.dao.Admin;
import javax.swing.*;
import java.sql.*;

public class CurriculumChoiceMethod {
    //定义变量并赋予方法
    String code;
    String week;
    String day;
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/db1?characterEncoding=utf8";
    private final String user="root";
    private final String sqlPassWord="320311";
    public boolean Judge() throws ClassNotFoundException {      // 判断选课是否规范
        if(this.code.equals("")){
            JOptionPane.showMessageDialog(null,"代号不能为空！","代号为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        if (this.week.equals("")){
            JOptionPane.showMessageDialog(null,"周数不能为空！","周数为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        if (this.day.equals("")){
            JOptionPane.showMessageDialog(null,"星期不能为空！","星期为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        if(this.time.equals("")){
            JOptionPane.showMessageDialog(null,"时间不能为空！","时间为空",JOptionPane.ERROR_MESSAGE);
            return  false;
        }
        String sql="select * from curriculum where Code="+this.code;
        Class.forName(driver);
        try {
            Connection conn= DriverManager.getConnection(url,user,sqlPassWord);
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            String type="必修";
            while(rs.next()){
                type= rs.getString("type");
            }

           if (type.equals("必修")){
               JOptionPane.showMessageDialog(null,"不能添加必修课！","不能添加必修课",JOptionPane.ERROR_MESSAGE);
               return false;
           }
           rs.close();
           ps.close();
           conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        add();
        return true;
    }
        void add() throws ClassNotFoundException {
        Class.forName(driver);
        String sql="insert into id_curriculum (user_id,curriculum_id,time,week,day) values (?,?,?,?,?)";
            try {
                Connection conn= DriverManager.getConnection(url,user,sqlPassWord);
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1, Admin.getStudentNumber());
                ps.setString(2,this.code);
                ps.setString(3,this.time);
                ps.setString(4,this.week);
                ps.setString(5,this.day);
                ps.executeUpdate();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
}
