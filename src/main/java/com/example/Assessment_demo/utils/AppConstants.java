package com.example.Assessment_demo.utils;

public class AppConstants {


    public static final String FIND_ALL_STUDENTS = "select s.student_id, s.student_name, s.course, s.specialization, s.percentage,d.department_id, d.department_name from student s join department d where s.department_id = d.department_id";



}
