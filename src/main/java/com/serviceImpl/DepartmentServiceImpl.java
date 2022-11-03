package com.serviceImpl;

import com.mapper.DepartmentMapper;
import com.pojo.Department;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    private static Integer iniId=1;

    @Override
    public List<Department> getDepartments() {
        return departmentMapper.getAllDpt();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentMapper.getDptById(id);
    }

    @Override
    public void addDepartment(Department department) {
        while (departmentMapper.getDptById(iniId) != null){
            iniId++;
        }
        if (department.getId() == null) {
            department.setId(iniId++);
        }
        departmentMapper.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public void deleteParment(Integer eid) {
        departmentMapper.deleteParment(eid);
    }
}
