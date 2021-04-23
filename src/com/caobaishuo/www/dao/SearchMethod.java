package com.caobaishuo.www.dao;

import com.caobaishuo.www.view.ResultInterface;

import java.sql.*;

public class SearchMethod {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/db1";
    private final String user = "root";
    private final String password = "320311";


    public void search(String text) throws Exception {
        //连接数据库并编写sql语句
      String o="'%"+text+"%'";
        String sql1 = "select * from curriculum where teacher like "+o+"or type like"+o+"or CourseTitle like"+o;
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement ps1=conn.createStatement();
        ResultSet rs1 = ps1.executeQuery(sql1);
        StringBuilder a = new StringBuilder();
        while (rs1.next()) {
            String code = rs1.getNString("Code");
            String teacher = rs1.getNString("teacher");
            String classroom = rs1.getNString("classroom");
            String type = rs1.getNString("type");
            String courseTitle = rs1.getNString("CourseTitle");
            a.append(code).append(teacher).append(classroom).append(type).append(courseTitle);
        }

        rs1.close();
        ps1.close();
        conn.close();
      ResultInterface.main(String.valueOf(a));

    }
}


