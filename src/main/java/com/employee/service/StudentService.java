package com.employee.service;

import com.employee.entity.Student;

import java.util.List;

public interface StudentService {
    String addStudent(Student student);

    List<Student> fetchStudents();

    String updateStudent(Student student);

    String deleteStudent(Long studentId);
}
