package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;
import com.example.demo.model.Member;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;

import org.springframework.jdbc.core.JdbcTemplate;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DepartmentRepository departmentRepository;


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
    public Project addProject(String name, Long departmentId) {
        Project project = new Project();
        project.setName(name);
        Department department = departmentRepository.findById(departmentId).orElse(null);
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

    public void addMemberToProject(Long projectId, Long memberId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        if (project != null && member != null) {
            String sql = "INSERT INTO project_member (project_id, member_id) VALUES (?, ?)";
            int rowsAffected = jdbcTemplate.update(sql, projectId, memberId);
        }
    }

    public void removeMemberFromProject(Long projectId, Long memberId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        if (project != null && member != null) {
            String sql = "DELETE FROM project_member WHERE project_id = ? AND member_id = ?";
            int rowsAffected = jdbcTemplate.update(sql, projectId, memberId);
        }
    }
}
