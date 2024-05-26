package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Department;

// - Department
//   - id, name, description

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d WHERE d.name = :name")
    Department findByName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.description = :description")
    Department findByDescription(@Param("description") String description);

    @Query("SELECT d FROM Department d WHERE d.name = :name AND d.description = :description")
    Department findByNameAndDescription(@Param("name") String name, @Param("description") String description);

    @Query("SELECT d FROM Department d WHERE d.name = :name OR d.description = :description")
    Department findByNameOrDescription(@Param("name") String name, @Param("description") String description);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    Department findByNameLike(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.description LIKE %:description%")
    Department findByDescriptionLike(@Param("description") String description);

}



