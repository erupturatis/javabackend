package com.example.demo.model;

// - Department
//   - id, name, description

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import com.example.demo.model.Project;

@Entity
public class Department {

    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private List<Project> projects;


    public Department() {
    }

    public Department(Long id, String name, String description, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projects = projects;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
