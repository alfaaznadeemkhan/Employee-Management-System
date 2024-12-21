package com.employee.serviceImpl;

import com.employee.entity.Employee;
import com.employee.entity.User;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.UserRepository;
import com.employee.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveEmployee(Employee employee) {

        Employee saveEmployee = Employee.builder()
                .name(employee.getName())
                .mobile(employee.getMobile())
                .designation(employee.getDesignation())
                .email(employee.getEmail())
                .hometown(employee.getHometown())
                .address(employee.getAddress())
                .build();

        employeeRepository.save(saveEmployee);

        return "Employee Added";

    }

    @Override
    public List<Employee> fetchAllEmployees() {

        List<Employee> employeeList = employeeRepository.findAll();

        return  employeeList;
    }

    @Override
    public Employee getSingleEmployee(Long id) {

       Employee singleEmployee =  employeeRepository.findById(id).get();

       return singleEmployee;

    }

    @Override
    public String deleteEmployee(Long id) {

        employeeRepository.deleteById(id);

        return "Employee Deleted";

    }

    @Override
    public String updateEmployee(Long id, Employee newEmp) {

        Optional<Employee> oldEmp = employeeRepository.findById(id);

        if(oldEmp.isPresent()) {
            Employee oldEmployee = oldEmp.get();

            oldEmployee.setName(newEmp.getName());
            oldEmployee.setMobile(newEmp.getMobile());
            oldEmployee.setDesignation(newEmp.getDesignation());
            oldEmployee.setEmail(newEmp.getEmail());
            oldEmployee.setHometown(newEmp.getHometown());
            oldEmployee.setAddress(newEmp.getAddress());

            employeeRepository.save(oldEmployee);

        }
        return "Employee Updated";
    }

    @Override
    public void saveUser(User user) {

        User saveUser =  User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        userRepository.save(saveUser);
    }

    @Override
    public List<User> fetchAllUsers() {

        List<User> users = userRepository.findAll();

        return users;

    }

    @Override
    public void updateUser(User user) {

        User oldUser = userRepository.findById(user.getUserId()).get();

        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());

        userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);

    }
}