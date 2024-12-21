package com.employee.service;

import com.employee.entity.Employee;
import com.employee.entity.User;

import java.util.List;

public interface EmployeeService {

    String saveEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    Employee getSingleEmployee(Long id);

    String deleteEmployee(Long id);

    String updateEmployee(Long id,Employee employee);

    void saveUser(User user);

    List<User> fetchAllUsers();

    void updateUser(User user);

    void deleteUser(Long userId);
}
