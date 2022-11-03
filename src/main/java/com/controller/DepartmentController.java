package com.controller;


import com.pojo.Department;
import com.pojo.Employee;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/finddept")
    public String list(Model model) {
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/deptlist";
    }

    //添加部门界面
    @GetMapping("/toAddDept")
    public String toAddDept(Model model) {
        return "emp/deptadd";
    }

    //添加部门
    @PostMapping("/addDept")
    public String addDept(Department department) {
        departmentService.addDepartment(department);
        return "redirect:/finddept";
    }

    //更新部门界面
    @GetMapping("/toUpdatedept")
    public String toUpdatedept(@RequestParam("id") Integer eid,Model model) {
        Department department = departmentService.getDepartmentById(eid);
        model.addAttribute("dept", department);
        return "emp/deptupdate";
    }

    //更新部门信息
    @PostMapping("/updateDepartment")
    public String updateDepartment(Department department) {
        departmentService.updateDepartment(department);
        return "redirect:/finddept";
    }

    //删除部门
    @GetMapping("/deleteParment")
    public String deleteParment(@RequestParam("id") Integer eid){
        departmentService.deleteParment(eid);
        return "redirect:/finddept";
    }
}
