package com.service;

import com.pojo.Department;

import java.util.List;

public interface DepartmentService {

    //获得所有部门信息
    public List<Department> getDepartments();

    //通过id得到部门
    public Department getDepartmentById(Integer id);

    //添加部门
    void addDepartment(Department department);


    //更新员工信息
    void updateDepartment(Department department);

    void deleteParment(Integer eid);
}
