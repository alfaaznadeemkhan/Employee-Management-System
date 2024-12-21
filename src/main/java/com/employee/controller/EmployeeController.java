package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.entity.User;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/home")
    public String home(Model m){

       List<Employee> employeeList = employeeService.fetchAllEmployees();

       m.addAttribute("employees",employeeList);

       List<User> user = employeeService.fetchAllUsers();

       m.addAttribute("user",user);

        return "home";
    }

    @GetMapping("/about")
    public String about(){

        return "about";
    }

    @GetMapping("/addEmployee")
    public String employeeCreationForm(){

        return "addEmployee";

    }

    @PostMapping("/saveEmployee")
    public String employeeCreationProcess(@ModelAttribute Employee employee,RedirectAttributes redirectModel){

        String message = employeeService.saveEmployee(employee);

        redirectModel.addFlashAttribute("message",message);

        return "redirect:/employee/home";
    }

    @RequestMapping("/updateEmployee/{id}")
    public String updateEmployeeForm(@PathVariable("id") Long id,Model m){

        Employee singleEmployee = employeeService.getSingleEmployee(id);

        m.addAttribute("employee",singleEmployee);

        return "updateEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployeeProcess(@RequestParam("id") Long id,@ModelAttribute Employee employee,RedirectAttributes redirectModel){

       String message = employeeService.updateEmployee(id,employee);

       redirectModel.addFlashAttribute("message",message);

        return "redirect:/employee/home";

    }

    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id")Long id,RedirectAttributes redirectModel){

        String message = employeeService.deleteEmployee(id);

        redirectModel.addFlashAttribute("message",message);

        return "redirect:/employee/home";

    }

//    User Work

//    Add User

    @PostMapping(path = "/saveUser")
    public String adduser(@ModelAttribute User user){

        employeeService.saveUser(user);

        return "redirect:/employee/home";

    }

//    Update User

    @PostMapping(path = "/updateUser")
    public String updateUser(@ModelAttribute User user){

        employeeService.updateUser(user);

        return "redirect:/employee/home";

    }

//    Delete User

    @GetMapping(path = "/delete/{userId}")
    public String deleteUser(@PathVariable(value = "userId")Long userId){

        employeeService.deleteUser(userId);

        return "redirect:/employee/home";

    }

}
