package com.example.Assessment_demo;

import com.example.Assessment_demo.entity.Department;
import com.example.Assessment_demo.entity.Student;
import com.example.Assessment_demo.repository.StudentRepo;
import com.example.Assessment_demo.service.StudentDetails;
import com.example.Assessment_demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTests {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepo studentRepo;

//    @Test
//    public void getStudentTest(){
//        List<StudentDetails> studentDetailsList = new ArrayList<>();
//        studentDetailsList.add(new StudentDetails(1, "John Doe", "BE", "Mathematics", 25L, 1) ));
//        studentDetailsList.add(new StudentDetails(1, "Jane Smith", "BE", "Chemistry", 22L, 1) ));
//        when(studentRepo.findAllStudents()).thenReturn(studentDetailsList);
//        assertEquals(1,studentService.getStudentDetails().size());
//    }

    @Test
    public void createStudentTest(){
        Student student = new Student(1,"Surya","BE","Chemistry",78L,1);
        when(studentRepo.save(student)).thenReturn(student);
        assertEquals(student,studentService.createStudent(student));
    }

    @Test
    public void deleteStudentTest(){
        int studentId =1;
        Student mockedStudent = new Student();
        mockedStudent.setStudentId(studentId);
        when(studentRepo.findById(studentId)).thenReturn(Optional.of(mockedStudent));
        studentService.deleteStudent(studentId);
        verify(studentRepo,times(1)).delete(mockedStudent);
    }

    @Test
    public void updateStudentTest(){
        int studentId =1;
        Student studentToUpdate = new Student(studentId,"Gowri","BE","Biology",68L,1);
        Student studentUpdated = new Student(studentId,"Surya","BE","Biology",68L,1);

        when(studentRepo.findById(studentId)).thenReturn(Optional.of(studentToUpdate));
        when(studentRepo.save(studentToUpdate)).thenReturn(studentUpdated);
        assertEquals(studentUpdated,studentService.updateStudent(studentToUpdate,studentId));
    }
}

