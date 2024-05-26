package com.example.demo.dto;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String description;
    private List<ProjectDTO> projects;


    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name, String description, List<ProjectDTO> projects) {
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

    public List<ProjectDTO> getProjects() {
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

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }


}
