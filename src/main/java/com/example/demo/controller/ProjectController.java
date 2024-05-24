package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import com.example.demo.repository.ProjectRepository;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    // get project by id
    @GetMapping("/project/{id}")
    public Project getProject(@PathVariable Long id) {
        return projectRepository.findById(id).orElse(null);
    }
    // get project members
    @GetMapping("/project/{id}/members")
    public List<Member> getProjectMembers(@PathVariable Long id) {
        return projectService.getProjectMembers(id);
    }

    // get all projects
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // add project
    @GetMapping("/project/add/{name}")
    public Project addProject(@PathVariable String name) {
        Project project = new Project();
        project.setName(name);
        return projectRepository.save(project);
    }

    // update project
    @GetMapping("/project/update/{id}/{name}")
    public Project updateProject(@PathVariable Long id, @PathVariable String name) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setName(name);
            return projectRepository.save(project);
        }
        return null;
    }

    // delete project
    @GetMapping("/project/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
    }

}
