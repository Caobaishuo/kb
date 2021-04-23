package com.caobaishuo.www.dao;

public class Admin {

    private static String username;
    private static String password;
    private static String StudentNumber;
    private static String major;
    private static String grade;
    private static String name;


    public static String getStudentNumber() {
        return StudentNumber;
    }

    public static void setStudentNumber(String studentNumber) {
        StudentNumber = studentNumber;
    }

    public static String getMajor() {
        return major;
    }

    public  static void setMajor(String major) {
        Admin.major = major;
    }

    public static String getGrade() {
        return grade;
    }

    public static void setGrade(String grade) {
        Admin.grade = grade;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Admin.name = name;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Admin.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public  static void setPassword(String password) {
        Admin.password = password;
    }
}
