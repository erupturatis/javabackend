package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.model.Department;
import com.example.demo.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectDTO;

import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // get department by id
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    // get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // get department projects
    public List<Project> getDepartmentProjects(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            return department.getProjects();
        }
        return null;
    }

    // add department
    public Department addDepartment(String name) {
        Department department = new Department();
        department.setName(name);
        return departmentRepository.save(department);
    }

    // update department
    public Department updateDepartment(Long id, String name) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.setName(name);
            return departmentRepository.save(department);
        }
        return null;
    }

    // delete department
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
