package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.service.DepartmentService;
import com.service.EmployeeService;
import com.pojo.Department;
import com.pojo.Employee;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    //员工列表页面
    @RequestMapping("/findEployees")
    public String list(Model model){
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees",employees);
        model.addAttribute("dpt",departmentService);
        return "emp/list";
    }

    //跳转到添加员工页面
    @GetMapping("/addEmp")
    public String toAddpage(Model model){
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("dpts",departments);
        return "emp/add";
    }

    //新增显示
    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
        //System.out.println("addEmployee==> "+employee);
        employeeService.save(employee);
        return "redirect:/findEployees";
    }

    //跳转到修改员工信息页面
    @GetMapping("/updateEmployee")
    public String toUpdateEmp(@RequestParam("id") Integer eid, Model model){
        List<Department> departments = departmentService.getDepartments();
        Employee employee = employeeService.getEmployeeById(eid);
        model.addAttribute("dpts",departments);
        model.addAttribute("employee",employee);
        return "emp/update";
    }

    //更新员工信息
    @GetMapping("/update")
    public String updateEmp(Employee employee){
        employeeService.update(employee);
        return "redirect:/findEployees";
    }

    //删除员工
    @GetMapping("/delete")
    public String deleteEmp(@RequestParam("id") Integer id){
        employeeService.delete(id);
        return "redirect:/findEployees";
    }

    //搜索
    @GetMapping("/findEployees/search")
    public String search(@RequestParam("word") String word,Model model){
        System.out.println(word);
        if (word.equals("")){
            List<Employee> employees = employeeService.getAll();

            model.addAttribute("employees",employees);
            model.addAttribute("dpt",departmentService);
        }
        else{
            List<Employee> employees = employeeService.search(word);
            model.addAttribute("employees",employees);
            model.addAttribute("dpt",departmentService);
            if (employees.size()==0){
                model.addAttribute("msg","查无此人！");
            }
        }
        return "emp/list";
    }
}
