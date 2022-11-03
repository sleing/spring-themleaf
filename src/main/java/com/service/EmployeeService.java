package com.service;

import com.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    //保存新员工
    void save(Employee employee);

    //更新员工信息
    void update(Employee employee);

    //查询全部员工
    List<Employee> getAll();

    //通过id查询员工
    Employee getEmployeeById(Integer id);

    //删除员工
    void delete(Integer id);

    List<Employee> search(String word);
}
