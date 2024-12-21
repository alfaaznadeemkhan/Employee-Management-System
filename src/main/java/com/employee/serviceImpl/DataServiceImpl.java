package com.employee.serviceImpl;

import com.employee.entity.Employee;
import com.employee.entity.Student;
import com.employee.entity.User;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.StudentRepository;
import com.employee.repository.UserRepository;
import com.employee.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Employee findEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).get();

        return employee;
    }

    @Override
    public User fetchUserById(Long userId) {

        User user = userRepository.findById(userId).get();

        return user;
    }

    @Override
    public Student fetchStudentById(Long studentId) {

        Student student = studentRepository.findById(studentId).get();

        return student;
    }
}
