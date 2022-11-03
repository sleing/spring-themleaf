package com.serviceImpl;

import com.mapper.DepartmentMapper;
import com.mapper.EmployeeMapper;
import com.pojo.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    //自动员工ID分配，初始员工编号1001
    private static Integer iniId = 1001;

    @Override
    public void save(Employee employee) {
        while (employeeMapper.getEmpById(iniId) != null) iniId++;
        if (employee.getId() == null) employee.setId(iniId++);
        employeeMapper.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @Override
    public void delete(Integer id) {
        employeeMapper.delete(id);
    }

    @Override
    public List<Employee> search(String word) {
        return employeeMapper.search(word);
    }
}
