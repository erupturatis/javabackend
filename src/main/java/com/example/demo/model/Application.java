package com.example.demo.model;


// - Application
//   -  id, project_id, name, motivation

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Application {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String name;
    private String motivation;

    @ManyToMany
    @JoinTable(name = "Application_Skill",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    public Application() {
    }

    public Application(Long id, Project project, String name, String motivation, List<Skill> skills) {
        this.id = id;
        this.project = project;
        this.name = name;
        this.motivation = motivation;
        this.skills = skills;
    }

    public Long getId() {
        return this.id;
    }

    public Project getProject() {
        return this.project;
    }

    public String getName() {
        return this.name;
    }

    public String getMotivation() {
        return this.motivation;
    }

    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }



}
