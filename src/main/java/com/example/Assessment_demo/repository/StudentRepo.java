package com.example.Assessment_demo.repository;

import com.example.Assessment_demo.entity.Student;
import com.example.Assessment_demo.service.StudentDetails;
import com.example.Assessment_demo.utils.AppConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query(value = AppConstants.FIND_ALL_STUDENTS,nativeQuery = true)
    List<StudentDetails> findAllStudents();
}
