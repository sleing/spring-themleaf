package com.pojo;


/*
 * 员工简单对象
 */
//@Data
//@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0代表女，1代表男

    private Integer departmentId;
    private String birthday;

    private float salary;

//    public Employee(Integer id, String lastName, String email, Integer gender, int departmentId) {
//        this.id = id;
//        this.lastName = lastName;
//        this.email = email;
//        this.gender = gender;
//        this.departmentId = departmentId;
//        //默认日期
//        this.birthday = new Date();
//    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
