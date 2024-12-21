package com.employee.serviceImpl;

import com.employee.entity.Student;
import com.employee.repository.StudentRepository;
import com.employee.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addStudent(Student student) {

        Student saveStudent = Student.builder()
                .studentName(student.getStudentName())
                .studentAge(student.getStudentAge())
                .studentClass(student.getStudentClass())
                .studentMobile(student.getStudentMobile())
                .studentAddress(student.getStudentAddress())
                .build();

        studentRepository.save(saveStudent);

        return "Student Added";
    }

    @Override
    public List<Student> fetchStudents() {

        List<Student> students = studentRepository.findAll();

        return students;
    }

    @Override
    public String updateStudent(Student student) {

        Long studentId = student.getStudentId();

        Student oldStudent = studentRepository.findById(studentId).get();

        oldStudent.setStudentName(student.getStudentName());
        oldStudent.setStudentAge(student.getStudentAge());
        oldStudent.setStudentMobile(student.getStudentMobile());
        oldStudent.setStudentClass(student.getStudentClass());
        oldStudent.setStudentAddress(student.getStudentAddress());

        studentRepository.save(oldStudent);

        return "Student Updated";
    }

    @Override
    public String deleteStudent(Long studentId) {

        studentRepository.deleteById(studentId);

        return "Student Deleted";
    }
}
