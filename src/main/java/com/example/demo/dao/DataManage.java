package com.example.demo.dao;

//数据管理接口
public interface DataManage {
    //增添数据
    public String addData(Student student);
    //删除数据
    public boolean deleteData(String studentAccount);
    //更改数据
    public boolean updateData(String studentAccount,String classID);
    //查找数据
    public Object searchData(String studentAccount);
}
