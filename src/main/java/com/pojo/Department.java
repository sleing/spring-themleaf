package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 部门简单对象
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Department {

    private Integer id;
    private String departmentName;
    private String location;

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
