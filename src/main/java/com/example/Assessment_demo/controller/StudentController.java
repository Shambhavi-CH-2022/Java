package com.example.Assessment_demo.controller;

import com.example.Assessment_demo.entity.Student;
import com.example.Assessment_demo.service.StudentDetails;
import com.example.Assessment_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public List<StudentDetails> getAllStudents(){
        return studentService.getStudentDetails();
    }
    @PostMapping("/students")
    public Student addStudents(@RequestBody Student student){
       return studentService.createStudent(student);
    }
    @PutMapping("/students/{studentId}")
    public Student editStudent(@RequestBody Student student,@PathVariable int studentId){

        return studentService.updateStudent(student,studentId);
    }
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
    }
}
