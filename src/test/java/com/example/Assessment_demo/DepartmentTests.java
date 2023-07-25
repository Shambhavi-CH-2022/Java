package com.example.Assessment_demo;

import com.example.Assessment_demo.entity.Department;
import com.example.Assessment_demo.repository.DepartmentRepo;
import com.example.Assessment_demo.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTests {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepo departmentRepo;

    @Test
    public void getDepartmentDetailsTest(){
        when(departmentRepo.findAll()).thenReturn(Stream.of(new Department(20,"ECE")).collect(Collectors.toList()));
        assertEquals(1,departmentService.getDepartmentDetails().size());
    }

    @Test
    public void createDepartmentTest(){
        Department department = new Department(1,"CSE");
        when(departmentRepo.save(department)).thenReturn(department);
        assertEquals(department,departmentService.createDepartment(department));
    }
    @Test
    public void deleteDepartmentTest(){
        int departmentId =1;
        Department mockedDepartment = new Department();
        mockedDepartment.setDepartmentId(departmentId);
        when(departmentRepo.findById(departmentId)).thenReturn(Optional.of(mockedDepartment));
        departmentService.deleteDepartment(departmentId);
        verify(departmentRepo,times(1)).delete(mockedDepartment);
    }

    @Test
    public void updateDepartmentTest(){
        int departmentId =1;
        Department departmentToUpdate = new Department(departmentId,"CSE");
        Department departmentUpdated = new Department(departmentId,"ECE");

        when(departmentRepo.findById(departmentId)).thenReturn(Optional.of(departmentToUpdate));
        when(departmentRepo.save(departmentToUpdate)).thenReturn(departmentUpdated);
        Department result = departmentService.updateDepartment(departmentToUpdate,departmentId);
        assertEquals(departmentUpdated,result);
    }
}
