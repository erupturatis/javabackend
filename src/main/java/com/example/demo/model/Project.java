package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    @ManyToMany(mappedBy = "projects")
    @JsonManagedReference
    private List<Member> members;



    public Project() {
    }

    public Project(Long id, String name, String description, Department department, List<Member> members) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.department = department;
        this.members = members;
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

    public Department getDepartment() {
        return this.department;
    }

    public List<Member> getMembers() {
        return this.members;
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

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
