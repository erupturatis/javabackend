package com.example.demo.controller;

import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.Department;
import com.example.demo.model.Project;

import java.util.List;

@CrossOrigin(origins = "localhost:5173", allowCredentials = "true")
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    // get department by id
    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    // get department projects
    @GetMapping("/department/{id}/projects")
    public List<Project> getDepartmentProjects(@PathVariable Long id) {
        return departmentService.getDepartmentProjects(id);
    }

    // get department by name
    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        // Assuming you have a method to find by name in your repository
        // Replace this line with the actual method call from DepartmentRepository
        return departmentRepository.findByName(name);
    }

    // get all departments
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // add department
    @GetMapping("/department/add/{name}")
    public Department addDepartment(@PathVariable String name) {
        Department department = new Department();
        department.setName(name);
        return departmentRepository.save(department);
    }

    // update department
    @GetMapping("/department/update/{id}/{name}")
    public Department updateDepartment(@PathVariable Long id, @PathVariable String name) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.setName(name);
            return departmentRepository.save(department);
        }
        return null;
    }

    // delete department
    @GetMapping("/department/delete/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }
}
