package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Department;

// - Department
//   - id, name, description

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByName(String name);

}



