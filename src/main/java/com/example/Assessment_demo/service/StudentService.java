package com.example.Assessment_demo.service;

import com.example.Assessment_demo.entity.Student;
import com.example.Assessment_demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public Student createStudent(Student student){
        return  studentRepo.save(student);
    }
    public List<StudentDetails> getStudentDetails(){
       return studentRepo.findAllStudents();
    }
    public Student updateStudent(Student student, int studentId){
        Optional<Student> existingStudent = Optional.ofNullable(studentRepo.findById(studentId).orElse(null));
        student.setStudentId(studentId);
        student.setStudentName(student.getStudentName());
        student.setCourse(student.getCourse());
        student.setSpecialization(student.getSpecialization());
        student.setPercentage(student.getPercentage());
        return studentRepo.save(student);
    }
    public void deleteStudent(int studentId){
        Student student = studentRepo.findById(studentId).orElse(null);
        studentRepo.delete(student);
    }
}
