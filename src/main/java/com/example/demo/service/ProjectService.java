package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // get project by id
    public Project getProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    // get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Member> getProjectMembers(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            return project.getMembers();
        }
        return null;
    }

    // add project
    public Project addProject(String name) {
        Project project = new Project();
        project.setName(name);
        return projectRepository.save(project);
    }

    // update project
    public Project updateProject(Long id, String name) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setName(name);
            return projectRepository.save(project);
        }
        return null;
    }

    // delete project
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
