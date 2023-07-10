package com.example.Assessment_demo.service;
import com.example.Assessment_demo.entity.Department;
import com.example.Assessment_demo.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    public Department createDepartment(Department department){
       return departmentRepo.save(department);
    }
    public List<Department> getDepartmentDetails(){
        return departmentRepo.findAll();
    }
    public Department updateDepartment(Department department, int departmentId){
        Optional<Department> existingDepartment = Optional.ofNullable(departmentRepo.findById(departmentId).orElse(null));
        department.setDepartmentId(departmentId);
        return departmentRepo.save(department);
    }
    public void deleteDepartment(int departmentId){
        Department department = departmentRepo.findById(departmentId).orElse(null);
        departmentRepo.delete(department);
    }
}
