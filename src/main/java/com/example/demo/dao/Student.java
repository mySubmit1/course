package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int studentID;
    private String studentAccount;
    private String studentPassword;
    private String studentName;
    private String studentSex;
    private String studentGrade;
    private int studentClass;
    private Class classes[];

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public void setClasses(Class[] classes) {
        this.classes = classes;
    }


    public String getStudentAccount() {
        return studentAccount;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public String  getStudentSex() {
        return studentSex;
    }

    public Class[] getClasses() {
        return classes;
    }
}
