package com.employee.service;

import com.employee.entity.Employee;
import com.employee.entity.Student;
import com.employee.entity.User;

import java.util.List;

public interface DataService {
    Employee findEmployeeById(Long id);

    User fetchUserById(Long userId);

    Student fetchStudentById(Long studentId);
}
