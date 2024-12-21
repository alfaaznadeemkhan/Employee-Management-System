package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.entity.Student;
import com.employee.entity.User;
import com.employee.serviceImpl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data")
public class DataController {


    @Autowired
    private DataServiceImpl dataService;

    @GetMapping(path = "/employeeData/{id}")
    public Employee fetchEmployeeData(@PathVariable(value = "id")Long id){

        Employee employee = dataService.findEmployeeById(id);

        return employee;

    }

    @GetMapping(path = "/userDetail/{userId}")
    public User fetchUser(@PathVariable(value = "userId")Long userId){

        User user = dataService.fetchUserById(userId);

        return user;

    }

    @GetMapping(path = "/fetchStudent/{studentId}")
    public Student fetchStudent(@PathVariable(value = "studentId")Long studentId){

    Student student = dataService.fetchStudentById(studentId);

    return student;

    }
}
