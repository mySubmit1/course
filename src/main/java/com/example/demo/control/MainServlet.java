package com.example.demo.control;

import com.example.demo.service.DataManageImpl;
import com.example.demo.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MainServlet {

    @Autowired
    DataManageImpl dataManage;

    /**
     * 实现登陆
     **/
    @ResponseBody
    @RequestMapping(value = "/signIn",method = RequestMethod.POST)
    public boolean signIn(String studentAccount, String studentPassword, HttpSession session) {
        List studentList = dataManage.searchData(studentAccount);
        try {
            if (studentList.get(0) == null) {
                System.out.println("查无此人");
                return false;
            } else if (((Map) studentList.get(0)).get("studentPassword").equals(studentPassword)) {
                System.out.println("验证成功");
                session.setAttribute("studentList", studentList);
                return true;
            } else {
                System.out.println("验证失败");
                return false;
            }
        } catch (NullPointerException nullException) {
            return false;
        }
    }

    /**
     * 实现注册功能
     **/
    @ResponseBody
    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public String singUp( String studentPassword, String studentName, String studentSex,String studentGrade){
        Student student = new Student();
        String studentAccount = null;
        student.setStudentPassword(studentPassword);
        student.setStudentName(studentName);
        student.setStudentSex(studentSex);
        student.setStudentGrade(studentGrade);
        studentAccount = dataManage.addData(student);
        return studentAccount;
    }

    /**
     * 获取用户数据
     **/
    @ResponseBody
    @RequestMapping(value = "/getStudentData",method = RequestMethod.POST)
    public List getStudentData(HttpSession session){
        return (List) session.getAttribute("studentList");
    }
    /**
     * 实现获取现有课程的功能
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllClasses",method = RequestMethod.POST)
    public List getAllClasses(){
        return dataManage.searchClass();
    }

    /**
    * 实现选课功能
    **/
    @ResponseBody
    @RequestMapping(value = "/chooseClasses",method = RequestMethod.POST)
    public boolean chooseClasses(String studentAccount,String classesID) {
        if (dataManage.updateData(studentAccount,classesID)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 实现删除用户功能
     **/
    @ResponseBody
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public boolean deleteClass(String studentAccount){
        System.out.println(studentAccount);
         dataManage.deleteData(studentAccount);
         return true;
    }
}
