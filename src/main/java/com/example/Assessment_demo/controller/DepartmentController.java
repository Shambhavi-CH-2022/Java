package com.example.Assessment_demo.controller;

import com.example.Assessment_demo.entity.Department;
import com.example.Assessment_demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public List<Department> getAllDepartments(){
        return departmentService.getDepartmentDetails();
    }
    @PostMapping("/department")
    public Department addDepartments(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }
    @PutMapping("/department/{departmentId}")
    public Department editDepartment(@RequestBody Department department,@PathVariable int departmentId){
        return departmentService.updateDepartment(department,departmentId);
    }
    @DeleteMapping("/department/{departmentId}")
    public void deleteStudent(@PathVariable int departmentId){
        departmentService.deleteDepartment(departmentId);
    }
}
