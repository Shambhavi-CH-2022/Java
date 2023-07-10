package com.example.Assessment_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(generator = "studentSeq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "studentSeq", sequenceName = "studentSeq", initialValue = 11, allocationSize = 1)
    private int studentId;
    private String studentName;
    private String course;
    private String specialization;
    private Long percentage;
    private int departmentId;
}
