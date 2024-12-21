package com.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
    private String designation;
    private String email;
    private String hometown;
    private String address;

}

