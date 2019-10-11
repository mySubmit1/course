package com.example.demo.service;

import com.example.demo.dao.DataManage;
import com.example.demo.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataManageImpl implements DataManage {

    static int initialAccount = 123456;

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public String addData(Student student) {
        String sql = null;
        sql = "insert into student_tb (studentAccount,studentPassword,studentName,studentSex,studentGrade,studentClass) value('"+(""+initialAccount)+"','"+student.getStudentPassword()+"','"+student.getStudentName()+"','"+student.getStudentSex()+"','"+student.getStudentGrade()+"','"+student.getStudentClass()+"')";
        jdbcTemplate.execute(sql);
        initialAccount++;
        return "" + (initialAccount-1);
    }

    @Override
    public boolean deleteData(String studentAccount) {
        String sql = null;
        sql = "delete from student_tb where studentAccount ='"+studentAccount+"'";
        try {
            jdbcTemplate.execute(sql);
        }catch (NullPointerException nullException){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateData(String studentAccount,String classID) {
        String sql = null;
        sql = "update student_tb set courseID = '"+classID+"'where studentAccount ="+studentAccount;
        try {
            jdbcTemplate.update(sql);
        }catch (NullPointerException nullException){
            return false;
        }
        return true;
    }

    @Override
    public List searchData(String studentAccount) {
        String sql = null;
        List studentList = new ArrayList();
        Map studentMap = null;
        String classID[] = null;
        sql = "select * from student_tb where studentAccount ='" + studentAccount + "'";
        studentMap = getMap(sql);
        if (studentMap == null){
            return null;
        }
        studentList.add(studentMap);
        String classesID = (String)studentMap.get("courseID");
        if (classesID != null){
            classID = classesID.split(";");
            for (int i = 0; i < classID.length; i++) {
                sql = "select * from course_tb where courseID ='" + classID[i] + "'";
                studentList.add(getMap(sql));
            }
        }
        return studentList;
    }

    public Map getMap(String sql){
        Map map = null;
        try {
            map = jdbcTemplate.queryForMap(sql);
        }catch (NullPointerException nullException){
            System.out.println("部分为空");
            return null;
        }catch (EmptyResultDataAccessException emptyException){
            System.out.println("全为空");
            return null;
        }
        return map;
    }

    public List searchClass(){
        String sql = null;
        List classList = null;
        sql = "select * from course_tb";
        classList = jdbcTemplate.queryForList(sql);
        return classList;
    }
}
