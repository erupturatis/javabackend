package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Member;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Project;
import com.example.demo.model.Department;
import com.example.demo.service.ProjectService;
import com.example.demo.repository.ProjectRepository;

import com.example.demo.dto.CreateProjectRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DepartmentRepository departmentRepository;

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

    @GetMapping("/project/name/{name}")
    public Project getProjectByName(@PathVariable String name) {
        return projectRepository.findByName(name);
    }


    // get all projects
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAllProjects();
    }

    // create project, needs project name and department name
    @PostMapping("/project/create")
    public ResponseEntity<Project> createProject(@RequestBody CreateProjectRequest createProjectRequest) {
        // Fetch the department entity using the provided departmentId
        Department department = departmentRepository.findById(createProjectRequest.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid department ID"));

        // Create the new project entity
        Project project = new Project();
        project.setName(createProjectRequest.getName());
        project.setDepartment(department);

        // Save the project entity to the database
        Project savedProject = projectRepository.save(project);

        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
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

    @GetMapping("/project/update/{id}/{name}/{description}")
    public Project updateProject(@PathVariable Long id, @PathVariable String name, @PathVariable String description) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setName(name);
            project.setDescription(description);
            return projectRepository.save(project);
        }
        return null;
    }

    // delete project
    @PostMapping("/project/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
    }

    @GetMapping("/project/new_member/{project_id}/{member_id}")
    public void addMemberToProject(@PathVariable Long project_id, @PathVariable Long member_id) {
        projectService.addMemberToProject(project_id, member_id);
    }

}
