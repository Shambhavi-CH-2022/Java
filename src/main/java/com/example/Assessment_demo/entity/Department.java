package com.example.Assessment_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(generator = "deptSeq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "deptSeq", sequenceName = "deptSeq", initialValue = 1, allocationSize = 1)
    private int departmentId;
    private String departmentName;
}
