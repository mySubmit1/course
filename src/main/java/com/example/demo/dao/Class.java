package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class Class {
    private int classID;
    private String className;
    private String classTeacher;
    private int classTime;

    public int getClassTime() {
        return classTime;
    }

    public void setClassTime(int classTime) {
        this.classTime = classTime;
    }

    public int getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }
}
