package com.employee.controller;

import com.employee.entity.Student;
import com.employee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Show Students
    @GetMapping(path = "/home")
    public String home(Model theModel){

        List<Student> students = studentService.fetchStudents();

        theModel.addAttribute("students",students);

        return "/student/students";
    }

    //Add Student
    @PostMapping(path = "/addStudent")
    public String addStudent(@ModelAttribute Student student, RedirectAttributes redirectModel){

        String message = studentService.addStudent(student);

        redirectModel.addFlashAttribute("message",message);

        return "redirect:/student/home";
    }

    //Update Student
    @PostMapping(path ="/updateStudent")
    public String updateStudent(@ModelAttribute Student student,RedirectAttributes redirectModel){

        String message = studentService.updateStudent(student);

        redirectModel.addFlashAttribute("message",message);

        return "redirect:/student/home";
    }

    //Delete Student
    @GetMapping(path = "/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable(value = "studentId")Long studentId,RedirectAttributes redirectModel){

        String message = studentService.deleteStudent(studentId);

        redirectModel.addFlashAttribute("message",message);

        return "redirect:/student/home";
    }

}
